package sg.edu.rp.c346.id20042321.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String wordClicked = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS=findViewById(R.id.tvDBS);
        tvOCBC=findViewById(R.id.tvOCBC);
        tvUOB=findViewById(R.id.tvUOB);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu1, menu);
        if (v == tvDBS){
            wordClicked = "DBS";
        }
        else if(v == tvOCBC){
            wordClicked = "OCBC";
        }
        else if(v == tvUOB){
            wordClicked = "UOB";
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onContextItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(wordClicked.equalsIgnoreCase("DBS")){
            if (id==R.id.website) { //check whether the selected menu item ID is 0
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(("https://www.dbs.com.sg")));
                startActivity(intent);
                return true;
            } else if (id==R.id.phonenumber) { //check if the selected menu item ID is 1
                //code for action
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse(("tel:"+"18001111111")));
                startActivity(intent);
                return true;
            }
        }
        else if(wordClicked.equalsIgnoreCase("OCBC")){
            if (id==R.id.website) { //check whether the selected menu item ID is 0
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(("https://www.ocbc.com")));
                startActivity(intent);
                return true;
            } else if (id==R.id.phonenumber) { //check if the selected menu item ID is 1
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse(("tel:"+"18003633333")));
                startActivity(intent);
                return true;
            }
        }
        else if(wordClicked.equalsIgnoreCase("UOB")){
            if (id==R.id.website) { //check whether the selected menu item ID is 0
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(("https://www.uob.com.sg")));
                startActivity(intent);
                return true;
            } else if (id==R.id.phonenumber) { //check if the selected menu item ID is 1
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse(("tel:"+"18002222121")));
                startActivity(intent);
                return true;
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);
    }
}



