package smarttimetable.main.windows.homefragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import smarttimetable.main.Model.DBModels.Lesson;
import smarttimetable.main.R;

public class LessonListAdapter extends RecyclerView.Adapter<LessonListAdapter.ViewHolder>{



    private LayoutInflater inflater;
    private List<Lesson> lessonItems;
    private List<Lesson> passItemsRemoved = new ArrayList<>();
    private Context context;

    private List<LessonListAdapter.ViewHolder> holders = new ArrayList<>();



    public interface OnItemClickListener {
        void onItemClick(Lesson passItem);
    }

    private OnItemClickListener onItemClickListener;


    public LessonListAdapter(Context context, List<Lesson> lessItemList,OnItemClickListener onItemClickListener) {
        this.lessonItems = lessItemList;
        this.inflater = LayoutInflater.from(context);
        this.onItemClickListener = onItemClickListener;
        this.context = context;

    }

    public void AddItem(Lesson lessonItem)
    {
        this.lessonItems.add(lessonItem);
        holders.clear();
        notifyDataSetChanged();
    }
    public List<Lesson> GetItemsList()
    {
        return this.lessonItems;
    }



    @Override
    public LessonListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.lessons_list_item, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(final LessonListAdapter.ViewHolder holder, final int position) {
        holders.add(holder);

        Lesson lessonItem = lessonItems.get(position);

        //holder.imageView.setImageResource(phone.getImage());
       // holder.itemName.setText(lessonItem.getName());
        //holder.b_delete.setVisibility(View.INVISIBLE);
        holder.itemTime.setText(lessonItem.getTime());



    }

    @Override
    public int getItemCount() {
        return lessonItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
       // final TextView itemName;
        final TextView itemTime;
        final LinearLayout item;
        ViewHolder(View view){
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Lesson passItem = lessonItems.get(getLayoutPosition());
                    //onItemClickListener.onItemClick(passItem);
                }
            });

            itemTime = (TextView)view.findViewById(R.id.tv_time);
            imageView = (ImageView)view.findViewById(R.id.image);
           // itemName = (TextView)view.findViewById(R.id.tv_itemName);
            item = (LinearLayout)view.findViewById(R.id.item);
        }

    }


}
