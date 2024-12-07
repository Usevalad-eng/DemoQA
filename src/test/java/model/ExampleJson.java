package model;

import com.google.gson.annotations.SerializedName;

public class ExampleJson {

    public String title;

    @SerializedName("example_div")
    public ExampleDiv exampleDiv;

    public static class ExampleDiv{
        public String title;
        public boolean flag;
    }
}
