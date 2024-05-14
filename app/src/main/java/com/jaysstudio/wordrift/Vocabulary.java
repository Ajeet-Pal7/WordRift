package com.jaysstudio.wordrift;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Vector;

public class Vocabulary implements Parcelable {

    Vector<String> Words = new Vector<>();
    Vector<String> Meanings = new Vector<>();

    public Vocabulary() {
    }

    public Vocabulary(Vector<String> words, Vector<String> meanings) {
        Words = words;
        Meanings = meanings;
    }

    protected Vocabulary(Parcel in) {
    }

    public static final Creator<Vocabulary> CREATOR = new Creator<Vocabulary>() {
        @Override
        public Vocabulary createFromParcel(Parcel in) {
            return new Vocabulary(in);
        }

        @Override
        public Vocabulary[] newArray(int size) {
            return new Vocabulary[size];
        }
    };

    public void setWordMeaning(String word, String mean){
        Words.add(word);
        Meanings.add(mean);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
    }
    String getWord(int index){
        return Words.get(index);
    }
    String getMeaning(int index){
        return Meanings.get(index);
    }
    public int count(){
        return Words.size();
    }
}
