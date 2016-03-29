package net.carlos.destaquesintaxe;

import android.text.TextWatcher;
import android.text.Editable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.text.style.ForegroundColorSpan;
import android.text.Spannable;
import android.graphics.Color;

public class SyntaxHighlight implements TextWatcher
{
   private List<String> keywords;
   private Editable e;
   
   public SyntaxHighlight()
   {
      keywords = Arrays.asList("if", "else", "switch", "break", "case", "int",
                 "byte", "long", "short");
   }
   
   @Override
   public void beforeTextChanged(CharSequence s, int start, int count, int after)
   {
      
   }

   @Override
   public void onTextChanged(CharSequence s, int start, int before, int count)
   {
      if (s.toString().substring(start).contains("{"))
      {
	 e.insert(start + 1, "}");
      }
      
      if (s.toString().substring(start).contains("("))
      {
	 e.insert(start + 1, ")");
      }
   }

   @Override
   public void afterTextChanged(Editable s)
   {
      this.e = s;
      
      for (int i = 0; i < keywords.size(); i++)
      {
	 if (s.toString().contains(keywords.get(i)))
	 {
	    int start = s.toString().lastIndexOf(keywords.get(i));
	    int end = keywords.get(i).length() + start;
	    
	    changeColor(s, start, end, Color.BLUE);
	 }
      }
   }
   
   private void changeColor(Editable e, int start, int end, int color)
   {
      e.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
   }
   
   public boolean addNewKeyword(String keyword)
   {
      return keywords.add(keyword);
   }
}
