package com.project.studentfacultyportal.activities;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.project.studentfacultyportal.R;

import java.util.ArrayList;
import java.util.List;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class ListFilesActivity extends AppCompatActivity {

    StorageReference storageReference;
    FirebaseStorage firebaseStorage;
    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_files);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.filesListView);
        final ArrayList<String> myFiles = new ArrayList<String>();
        myFiles.add("FILE_CN");
        myFiles.add("FILE_TAFL");
        myFiles.add("FILE_OOSE");
        myFiles.add("FILE_SOC");
        myFiles.add("FILE_NIS");
        myFiles.add("FILE_151");
        myFiles.add("FILE_200");
        myFiles.add("FILE_Modi");
        myFiles.add("FILE_Artificial Intelligence ");
        myFiles.add("FILE_Machine Learning");
        myFiles.add("FILE_1808");
        myFiles.add("FILE_1807");
        myFiles.add("FILE_SE");
        myFiles.add("FILE_JT");
        myFiles.add("FILE_SDP");
        myFiles.add("FILE_Random");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFiles);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "Hello " + myFiles.get(position), Toast.LENGTH_LONG).show();
                switch (myFiles.get(position)) {
                    case "FILE_CN":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File_cn(BMG).pdf_1554611274660");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File_cn(BMG).pdf_1554611274660", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;
                    case "FILE_TAFL":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File_TAFL.pdf");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File_TAFL.pdf", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;
                    case "FILE_OOSE":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File_OOSE.pdf1551872647144");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File_OOSE.pdf1551872647144", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;
                    case "FILE_SOC":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File11551811791065");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File11551811791065", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;
                    case "FILE_NIS":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File_1034_1553022302472");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File_1034_1553022302472", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;
                    case "FILE_151":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File_151_1554572816999");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File_151_1554572816999", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;
                    case "FILE_200":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File_example.pdf1551872820940");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File_example.pdf1551872820940", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;

                    case "FILE_Modi":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File_cn(BMG).pdf_1554611274660");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File_cn(BMG).pdf_1554611274660", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;
                    case "FILE_Artificial Intelligence":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File_cn(BMG).pdf_1554611274660");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File_cn(BMG).pdf_1554611274660", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;
                    case "FILE_Machine Learning":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File_cn(BMG).pdf_1554611274660");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File_cn(BMG).pdf_1554611274660", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;
                    case "FILE_1808":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File_cn(BMG).pdf_1554611274660");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File_cn(BMG).pdf_1554611274660", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;
                    case "FILE_1807":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File_cn(BMG).pdf_1554611274660");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File_cn(BMG).pdf_1554611274660", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;
                    case "FILE_Random":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File_cn(BMG).pdf_1554611274660");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File_cn(BMG).pdf_1554611274660", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;
                    case "FILE_SDP":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File_cn(BMG).pdf_1554611274660");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File_cn(BMG).pdf_1554611274660", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;
                    case "FILE_SE":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File_cn(BMG).pdf_1554611274660");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File_cn(BMG).pdf_1554611274660", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;case "FILE_JT":
                        //Toast.makeText(ListFilesActivity.this, "CN", Toast.LENGTH_SHORT).show();
                        storageReference = firebaseStorage.getInstance().getReference();
                        ref = storageReference.child("FileUploads").child("File_cn(BMG).pdf_1554611274660");
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                downloadFiles(ListFilesActivity.this, "File_cn(BMG).pdf_1554611274660", ".pdf", DIRECTORY_DOWNLOADS, url);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                        break;


                }
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            */
                Intent i = new Intent(ListFilesActivity.this,GeneralActivity.class);
                startActivity(i);
            }
        });
    }

    public void downloadFiles(Context context, String fileName, String fileExtension, String destinationDir, String url) {

        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDir, fileName + fileExtension);
        downloadManager.enqueue(request);

    }

}
