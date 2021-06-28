package com.example.st;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    EditText eName, eLastName, eEmail, ePassword, ePasswordConf, eType, eUsername;
    TextView eNameErr, eLastNameErr, eEmailErr, ePasswordErr, ePasswordConfErr, eTypeErr, eUsernameErr ;
    Button signUp;
    ImageView photo;
    AlertDialog.Builder builder;
    public static final String KEY_User_Document1 = "doc1";
    ImageView IDProf;
    Button Upload_Btn;
    TextView loginBtn;

    private String Document_img1="";


    public final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9+._%-+]{1,256}" +
                    "@" +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" +
                    "(" +
                    "." +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" +
                    ")+"
    );

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eName = (EditText) findViewById(R.id.FirstNameFill);
        eLastName = (EditText) findViewById(R.id.LastNameFill);
        eUsername = (EditText) findViewById(R.id.UsernameFill);
        eEmail = (EditText) findViewById(R.id.EmailFill);
        ePassword = (EditText) findViewById(R.id.PasswordFill);
        ePasswordConf = (EditText) findViewById(R.id.ConPasswordFill);
        eType = (EditText) findViewById(R.id.TypeFill);
        signUp = (Button) findViewById(R.id.SignUpBtn);
        photo = (ImageView) findViewById(R.id.enterPhoto);
        loginBtn = (TextView) findViewById(R.id.LoginButton);
        eNameErr = (TextView) findViewById(R.id.firstNameErr);
        eLastNameErr = (TextView) findViewById(R.id.lastNameErr);
        eUsernameErr = (TextView) findViewById(R.id.usernameErr);
        eEmailErr = (TextView) findViewById(R.id.emailErr);
        eTypeErr = (TextView) findViewById(R.id.typeErr);
        ePasswordErr = (TextView) findViewById(R.id.passErr);
        ePasswordConfErr = (TextView) findViewById(R.id.confpassErr);


        GlobalClass globalClass = new GlobalClass();
        UserData user = new UserData(eName.getText().toString(), eLastName.getText().toString(), eUsername.getText().toString(), eEmail.getText().toString(),ePassword.getText().toString());
        globalClass.dataBase.add(user);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), login.class);
                startActivity(intent);
            }
        });

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();

            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNullError();
                signUp = (Button) findViewById(R.id.SignUpBtn) ;
                Intent intent = new Intent(v.getContext(), home_screen.class);
                if(validate()) startActivity(intent);
            }
            private boolean validate() {
                boolean temp=true;
                String checkemail = eEmail.getText().toString();
                String pass=ePassword.getText().toString();
                String cpass=ePasswordConf.getText().toString();
                String name = eName.getText().toString();
                String lastName = eLastName.getText().toString();
                String type = eType.getText().toString();
                String username = eUsername.getText().toString();


                if(name.equals("")){
                    eNameErr.setText("Please enter information");
                }
                if(lastName.equals("")){
                    eLastNameErr.setText("Please enter information");
                }
                if(type.equals("")){
                    eTypeErr.setText("Please enter information");
                }
                if(username.equals("")){
                    eUsernameErr.setText("Please enter information");
                }
                if(checkemail.equals("")){
                    eEmailErr.setText("Please enter information");
                }
                if(pass.equals("")){
                    ePasswordErr.setText("Please enter information");
                }
                if(cpass.equals("")){
                    ePasswordConfErr.setText("Please enter information");
                }
                if(!EMAIL_ADDRESS_PATTERN.matcher(checkemail).matches()){
                    Toast.makeText(Register.this,"Invalid Email Address",Toast.LENGTH_SHORT).show();
                    eEmailErr.setText("Wrong Email");
                    temp=false;
                }
                if(!pass.equals(cpass)){
                    Toast.makeText(Register.this,"Password Not matching",Toast.LENGTH_SHORT).show();
                    ePasswordErr.setText("Passwords are not matching");
                    ePasswordConfErr.setText("Passwords are not matching");
                    temp=false;
                }
                return temp;
            }
        });

    }

    private void setNullError() {
        eNameErr.setText("");
        eLastNameErr.setText("");
        eUsernameErr.setText("");
        eEmailErr.setText("");
        ePasswordErr.setText("");
        ePasswordConfErr.setText("");
        eTypeErr.setText("");
    }

    private void selectImage() {
        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo"))
                {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                    File f = new File(android.os.Environment.getExternalStorageState());
//                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent, 1);
                }
                else if (options[item].equals("Choose from Gallery"))
                {
                    Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                }
                else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(), bitmapOptions);
                    bitmap=getResizedBitmap(bitmap, 400);
                    photo.setImageBitmap(bitmap);
                    BitMapToString(bitmap);
                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == 2) {
                Uri selectedImage = data.getData();
                String[] filePath = { MediaStore.Images.Media.DATA };
                Cursor c = getContentResolver().query(selectedImage,filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                thumbnail=getResizedBitmap(thumbnail, 400);
                Log.w("path of image from gallery......******************.........", picturePath+"");
                photo.setImageBitmap(thumbnail);
                BitMapToString(thumbnail);
            }
        }
    }
    public String BitMapToString(Bitmap userImage1) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        userImage1.compress(Bitmap.CompressFormat.PNG, 60, baos);
        byte[] b = baos.toByteArray();
        Document_img1 = Base64.encodeToString(b, Base64.DEFAULT);
        return Document_img1;
    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float)width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }




}