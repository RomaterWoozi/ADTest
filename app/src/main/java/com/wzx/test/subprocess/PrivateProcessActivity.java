package com.wzx.test.subprocess;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.wzx.test.ISubService;
import com.wzx.test.R;

import static com.wzx.test.Util.setCurrentRunningProcess;

/**
 * Created By WuZhouXing TestApplication
 * 2019/4/17 13:46
 */
public class PrivateProcessActivity extends Activity implements AdapterView.OnItemClickListener {
    private TextView privateProcessNameTextView;
    private TextView selectedListItemTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_process);
        privateProcessNameTextView = findViewById(R.id.textPrivateProcessName);
        setCurrentRunningProcess(privateProcessNameTextView, this);

        selectedListItemTextView = findViewById(R.id.selectedListItemText);
        ListView listView = findViewById(R.id.list);
        String[] listItems = getResources().getStringArray(R.array.list_items);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public void onBtnClick(View view) {
        TextView v = findViewById(R.id.displayTextView);
        v.setText(R.string.button_clicked);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectedListItemTextView.setText(
                String.format(getString(R.string.list_selection), ((TextView) view).getText()));
    }








}
