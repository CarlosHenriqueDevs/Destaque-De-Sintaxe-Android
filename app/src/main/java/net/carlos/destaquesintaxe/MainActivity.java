/******************************************
 *
 * Criado por Carlos
 *
 * Siga-me no twitter (@CarlosIdeScript)
 *
 ******************************************/

package net.carlos.destaquesintaxe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.graphics.Typeface;

public class MainActivity extends Activity 
{
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);

      EditText editor = (EditText) findViewById(R.id.edEditor);
      editor.setTypeface(Typeface.MONOSPACE);
      editor.addTextChangedListener(new SyntaxHighlight());
   }
}
