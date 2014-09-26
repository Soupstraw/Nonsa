package root.nonsa;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.InetAddress;
import java.net.Socket;


public class MainActivity extends ActionBarActivity {

    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button send_button = (Button) findViewById(R.id.send_button);
        // Set up the send button
        send_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                TextView log = (TextView) findViewById(R.id.chat_log);
                EditText box = (EditText) findViewById(R.id.message_box);
                log.setText(log.getText() + "\n" + box.getText());
                box.setText("");
            }
        });
        // Start client
        client = new Client();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
