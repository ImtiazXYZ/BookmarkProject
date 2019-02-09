package com.example.nonitech.bookmarkproject;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static com.example.nonitech.bookmarkproject.APi.BASE_URL;

public class BookMarkAdapter extends RecyclerView.Adapter<BookMarkAdapter.BookMarkAdapterHolder> {
    Context bookmarkcontext;
    BookmarkModel bookmarkModel;
    List<BookmarkModel> bookmarkModels;
    private ArrayList<String> mImageNames = new ArrayList<>();
    boolean savedata=false;
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mAge = new ArrayList<>();
    private ArrayList<String> mDescription = new ArrayList<>();

    public BookMarkAdapter(Context bookmarkcontext, List<BookmarkModel> bookmarkModels) {
        this.bookmarkcontext = bookmarkcontext;
        this.bookmarkModels = bookmarkModels;
    }

    public BookMarkAdapter(Context bookmarkcontext, List<BookmarkModel> bookmarkModels, ArrayList<String> mImageNames, ArrayList<String> mImages, ArrayList<String> mAge, ArrayList<String> mDescription) {
        this.bookmarkcontext = bookmarkcontext;
        this.bookmarkModels = bookmarkModels;
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mAge = mAge;
        this.mDescription = mDescription;
    }

    public BookMarkAdapter(Context bookmarkcontext, ArrayList<String>mImages , ArrayList<String> mImageNames, ArrayList<String> mAge, ArrayList<String> mDescription) {
        this.bookmarkcontext = bookmarkcontext;
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mAge = mAge;
        this.mDescription = mDescription;
    }

    @NonNull
    @Override
    public BookMarkAdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(bookmarkcontext);
        View view=layoutInflater.inflate(R.layout.row_view,null);
        return new BookMarkAdapterHolder(view);
    }

  /*  public void setBookMarkList(List<BookmarkModel> bookMarkList){
        this.bookmarkModels=bookMarkList;
        //Notifies the attached observers that the underlying data has been changed and any View reflecting the data set should refresh itself.
        notifyDataSetChanged();

    }*/

    @Override
    public void onBindViewHolder(@NonNull BookMarkAdapterHolder bookMarkAdapterHolder,final int i) {
//         bookmarkModel=bookmarkModels.get(i);
        final String imageurl=BASE_URL+"images/";
       /* Glide.with(bookmarkcontext).load(imageurl + bookmarkModel.getImage()).into(bookMarkAdapterHolder.bookmarkImage);
        bookMarkAdapterHolder.nameText.setText(bookmarkModel.getName());
        bookMarkAdapterHolder.ageText.setText(bookmarkModel.getAge());
        bookMarkAdapterHolder.descriptionText.setText(bookmarkModel.getDescription());*/
       Glide.with(bookmarkcontext).load(imageurl+mImages.get(i)).into(bookMarkAdapterHolder.bookmarkImage);
       bookMarkAdapterHolder.nameText.setText(mImageNames.get(i));
       bookMarkAdapterHolder.ageText.setText(mAge.get(i));
       bookMarkAdapterHolder.descriptionText.setText(mDescription.get(i));


        bookMarkAdapterHolder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bookmarkcontext,GalleryBookmark.class);
                intent.putExtra("image",mImages.get(i));
                intent.putExtra("name",mImageNames.get(i));
                intent.putExtra("age",mAge.get(i));
                intent.putExtra("description",mDescription.get(i));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                bookmarkcontext.startActivity(intent);


            }
        });

        bookMarkAdapterHolder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseBookmark databaseBookmark=Room.databaseBuilder(bookmarkcontext,DatabaseBookmark.class,"bookmark_data").allowMainThreadQueries().build();
                String image_url=imageurl+mImages.get(i);
                String name=mImageNames.get(i);
                String age= mAge.get(i);
                String des=mDescription.get(i);
                BookMarkTable bookMarkTable=new BookMarkTable();
                bookMarkTable.setImage_url(image_url);
                bookMarkTable.setName(name);
                bookMarkTable.setAge(age);
                bookMarkTable.setDescription(des);
                databaseBookmark.bookmarkInterfaceDAO().insert(bookMarkTable);
                savedata=true;
                if (savedata) {
                    Toast.makeText(bookmarkcontext, "Data saved in Room", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(bookmarkcontext, "failed", Toast.LENGTH_SHORT).show();
                }
                }
        });



    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    class BookMarkAdapterHolder extends RecyclerView.ViewHolder {
        ImageView bookmarkImage,clickImageView;
        TextView nameText,ageText,descriptionText;
        LinearLayout parentlayout;
        Button click;

        public BookMarkAdapterHolder(@NonNull View itemView) {
            super(itemView);
            bookmarkImage=itemView.findViewById(R.id.ivStar);
            nameText=itemView.findViewById(R.id.tvName);
            ageText=itemView.findViewById(R.id.ageTV);
            descriptionText=itemView.findViewById(R.id.desTV);
          /*  clickImageView=itemView.findViewById(R.id.clickImage);*/
            click=itemView.findViewById(R.id.clickImage);
            parentlayout=itemView.findViewById(R.id.rowviewLayout);
            

            


        }
    }
}
