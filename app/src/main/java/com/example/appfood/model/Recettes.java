package com.example.appfood.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Recettes implements Parcelable {
    private Integer id;

    //constructeure pour faire passer un objet d'une activiter
    protected Recettes(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        descrition = in.readString();
        type = in.readString();
        if (in.readByte() == 0) {
            image = null;
        } else {
            image = in.readInt();
        }
        if (in.readByte() == 0) {
            calorie = null;
        } else {
            calorie = in.readInt();
        }
        if (in.readByte() == 0) {
            temps_de_preparation = null;
        } else {
            temps_de_preparation = in.readInt();
        }
        if (in.readByte() == 0) {
            nombre_d_ingrediant = null;
        } else {
            nombre_d_ingrediant = in.readInt();
        }
        byte tmpFav = in.readByte();
        fav = tmpFav == 0 ? null : tmpFav == 1;
    }

    public static final Creator<Recettes> CREATOR = new Creator<Recettes>() {
        @Override
        public Recettes createFromParcel(Parcel in) {
            return new Recettes(in);
        }

        @Override
        public Recettes[] newArray(int size) {
            return new Recettes[size];
        }
    };

    public int getId() {
        return id;
    }

    public Recettes() {
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private  String descrition;
    private String type;
    private Integer image;
    private Integer calorie;
    private Integer temps_de_preparation;
    private Integer nombre_d_ingrediant;
    private Boolean fav = true;

    public Recettes(Integer id, String name, String descrition, String type, Integer image, Integer calorie, Integer temps_de_preparation, Integer nombre_d_ingrediant, Boolean fav) {
        this.id = id;
        this.name = name;
        this.descrition = descrition;
        this.type = type;
        this.image = image;
        this.calorie = calorie;
        this.temps_de_preparation = temps_de_preparation;
        this.nombre_d_ingrediant = nombre_d_ingrediant;
        this.fav = fav;
    }

    public Recettes(String name, String descrition, String type, Integer image) {
        this.name = name;
        this.descrition = descrition;
        this.type = type;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Boolean getFav() {
        return fav;
    }


    public Integer getNombre_d_ingrediant() {
        return nombre_d_ingrediant;
    }

    public void setNombre_d_ingrediant(Integer nombre_d_ingrediant) {
        this.nombre_d_ingrediant = nombre_d_ingrediant;
    }

    public void setFav(Boolean fav) {
        this.fav = fav;
    }

    public Integer getCalorie() {
        return calorie;
    }

    public void setCalorie(Integer calorie) {
        this.calorie = calorie;
    }

    public void setTemps_de_preparation(Integer temps_de_preparation) {
        this.temps_de_preparation = temps_de_preparation;
    }

    public Integer getTemps_de_preparation() {
        return temps_de_preparation;
    }

    @Override
    public String toString() {
        return "Recettes{" +
                "name='" + name + '\'' +
                ", descrition='" + descrition + '\'' +
                ", type='" + type + '\'' +
                ", image=" + image +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDescrition() {
        return descrition;
    }

    public String getType() {
        return type;
    }

    public Integer getImage() {
        return image;
    }

    public Recettes(String name, String descrition, String type) {
        this.name = name;
        this.descrition = descrition;
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        parcel.writeString(name);
        parcel.writeString(descrition);
        parcel.writeString(type);
        if (image == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(image);
        }
        if (calorie == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(calorie);
        }
        if (temps_de_preparation == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(temps_de_preparation);
        }
        if (nombre_d_ingrediant == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(nombre_d_ingrediant);
        }
        parcel.writeByte((byte) (fav == null ? 0 : fav ? 1 : 2));
    }
}
