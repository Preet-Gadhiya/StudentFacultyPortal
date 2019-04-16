package com.project.studentfacultyportal.activities;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.project.studentfacultyportal.R;

public class FileUpload extends AppCompatActivity {
    Button selectFile, uploadFile;
    TextView notification;
    FirebaseStorage storage;
    FirebaseDatabase database;
    DatabaseReference reference;
    StorageReference storageReference;
    StorageReference ref;

    String url;
    //    FirebaseAuth mAuth = FirebaseAuth.getInstance();
//    FirebaseUser user = mAuth.getCurrentUser();
    Uri pdfUri;
    ProgressDialog progressDialog;
    String fileName = "File_";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_upload);

//        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();
        selectFile = findViewById(R.id.selectFile);
        uploadFile = findViewById(R.id.uploadFile);
        notification = findViewById(R.id.notification);

        selectFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(FileUpload.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    selectPdf();
                } else
                    ActivityCompat.requestPermissions(FileUpload.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 9);
            }
        });

        uploadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pdfUri != null) {
//                    if(user!= null)
                    doUpload(pdfUri);
//                    else
//                        signInAnonymously();
                } else
                    Toast.makeText(FileUpload.this, "Select a file", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void doUpload(Uri pdfUri) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File....");
        progressDialog.setProgress(0);
        progressDialog.show();

        storageReference = storage.getInstance().getReference();


        storageReference.child("FileUploads").child(fileName).putFile(pdfUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        getDownloadableLink();
                        ref = storageReference.child("FileUploads").child(fileName);
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                url = uri.toString();
                                DatabaseReference reference = database.getReference();
                                reference.child(fileName).setValue(url)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (!task.isSuccessful())
                                                    Toast.makeText(FileUpload.this, "Error Uploading File", Toast.LENGTH_SHORT).show();
                                                else {
                                                    Toast.makeText(FileUpload.this, "File Uploaded Succesfully", Toast.LENGTH_SHORT).show();
                                                    //Toast.makeText(FileUpload.this,url,Toast.LENGTH_SHORT);
                                                }
                                            }
                                        });
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(FileUpload.this, "File Not Uploaded Succesfully", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                //tracks progress
                int currentProgress = (int) (100 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentProgress);
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 9 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            selectPdf();
        else
            Toast.makeText(FileUpload.this, "Please Provide Permission to access files", Toast.LENGTH_SHORT).show();
    }

    private void selectPdf() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 86);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 86 && resultCode == RESULT_OK && data != null) {   //check for pdf
            fileName += data.getData().getLastPathSegment() + "_" + System.currentTimeMillis() + "";
            notification.setText("A File selected : " + data.getData().getLastPathSegment());
            pdfUri = data.getData();
        } else
            Toast.makeText(FileUpload.this, "Please Select a file", Toast.LENGTH_SHORT).show();
    }
}
