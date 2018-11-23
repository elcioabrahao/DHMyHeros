package br.com.doghero.dhmyheros.ui.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import br.com.doghero.dhmyheros.R;
import br.com.doghero.dhmyheros.domain.model.HeroItem;
import br.com.doghero.dhmyheros.ui.fragments.HeroFragment;
import android.view.Menu;
import android.view.MenuItem;

import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

public class MainActivity extends AppCompatActivity implements HeroFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            new FancyGifDialog.Builder(this)
                    .setTitle(getResources().getString(R.string.about_title_text))
                    .setMessage(getResources().getString(R.string.about_title_message))
                    .setPositiveBtnBackground("#ffef3a5d")
                    .setPositiveBtnText(getResources().getString(R.string.about_ok))
                    .setNegativeBtnText(getResources().getString(R.string.about_cancel))
                    .setGifResource(R.drawable.dev)
                    .isCancellable(true)
                    .OnPositiveClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {

                        }
                    })
                    .OnNegativeClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {

                        }
                    })
                    .build();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListFragmentInteraction(HeroItem item) {

    }
}
