package org.FaneFonseka.LearningGames2;

/**
 * Created by Fane on 04/12/2016.
 */
public class PrimitiveDataType {

    final String name;


    int getMemorySizeInBits() {
        return memorySizeInBits;
    }

    final int memorySizeInBits;


    PrimitiveDataType(String name, int memorySizeInBits){

        this.name = name;
        this.memorySizeInBits = memorySizeInBits;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrimitiveDataType that = (PrimitiveDataType) o;

        if (memorySizeInBits != that.memorySizeInBits) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

}
