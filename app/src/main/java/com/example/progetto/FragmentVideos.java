package com.example.progetto;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.MediaController;
import android.widget.VideoView;

public class FragmentVideos extends Fragment implements View.OnClickListener{

    View view;
    VideoView  videoView1;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_videos, container, false);

        videoView1 = (VideoView) view.findViewById(R.id.video_view);
        String vPath = "android.resource://" + getActivity().getPackageName() + "/raw/rinfiggivideo2";

        Uri videoURI = Uri.parse(vPath);

        videoView1.setVideoURI(videoURI);
        //videoView1.start();

        MediaController mediaController = new MediaController(getContext());
        videoView1.setMediaController(mediaController);
        mediaController.setAnchorView(videoView1);



        return view;
    }

    @Override
    public void onClick(View view) {

    }
}