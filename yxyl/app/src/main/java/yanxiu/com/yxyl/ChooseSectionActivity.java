package yanxiu.com.yxyl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import yanxiu.com.adapter.Section;
import yanxiu.com.adapter.SectionAdapter;

public class ChooseSectionActivity extends AppCompatActivity {
   private List<Section> sections=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_section);
        initSection();
        SectionAdapter sectionAdapter=new SectionAdapter(this,R.layout.sectionitem,sections);
        ListView listView= (ListView) findViewById(R.id.ls_list_section_item);
        listView.setAdapter(sectionAdapter);

    }


    private void initSection() {
        Section xx = new Section("小学");
        sections.add(xx);
        Section cz = new Section("初中");
        sections.add(cz);
        Section gz = new Section("高中");
        sections.add(gz);

    }
}
