package com.example.food.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeSearchModel{
    public String q;
    public int from;
    public int to;
    public boolean more;
    public int count;
    public List<Hit> hits;
}

class ENERCKCAL{
    public String label;
    public double quantity;
    public String unit;
}

class FAT{
    public String label;
    public double quantity;
    public String unit;
}

class FASAT{
    public String label;
    public double quantity;
    public String unit;
}

class FATRN{
    public String label;
    public double quantity;
    public String unit;
}

class FAMS{
    public String label;
    public double quantity;
    public String unit;
}

class FAPU{
    public String label;
    public double quantity;
    public String unit;
}

class CHOCDF{
    public String label;
    public double quantity;
    public String unit;
}

class FIBTG{
    public String label;
    public double quantity;
    public String unit;
}

class SUGAR{
    public String label;
    public double quantity;
    public String unit;
}

class PROCNT{
    public String label;
    public double quantity;
    public String unit;
}

class CHOLE{
    public String label;
    public double quantity;
    public String unit;
}

class NA{
    public String label;
    public double quantity;
    public String unit;
}

class CA{
    public String label;
    public double quantity;
    public String unit;
}

class MG{
    public String label;
    public double quantity;
    public String unit;
}

class K{
    public String label;
    public double quantity;
    public String unit;
}

class FE{
    public String label;
    public double quantity;
    public String unit;
}

class ZN{
    public String label;
    public double quantity;
    public String unit;
}

class P{
    public String label;
    public double quantity;
    public String unit;
}

class VITARAE{
    public String label;
    public double quantity;
    public String unit;
}

class VITC{
    public String label;
    public double quantity;
    public String unit;
}

class THIA{
    public String label;
    public double quantity;
    public String unit;
}

class RIBF{
    public String label;
    public double quantity;
    public String unit;
}

class NIA{
    public String label;
    public double quantity;
    public String unit;
}

class VITB6A{
    public String label;
    public double quantity;
    public String unit;
}

class FOLDFE{
    public String label;
    public double quantity;
    public String unit;
}

class FOLFD{
    public String label;
    public double quantity;
    public String unit;
}

class FOLAC{
    public String label;
    public double quantity;
    public String unit;
}

class VITB12{
    public String label;
    public double quantity;
    public String unit;
}

class VITD{
    public String label;
    public double quantity;
    public String unit;
}

class TOCPHA{
    public String label;
    public double quantity;
    public String unit;
}

class VITK1{
    public String label;
    public double quantity;
    public String unit;
}

class WATER{
    public String label;
    public double quantity;
    public String unit;
}

class TotalNutrients{
    @SerializedName("ENERC_KCAL")
    @Expose
    public ENERCKCAL eNERC_KCAL;
    @SerializedName("FAT")
    @Expose
    public FAT fAT;
    @SerializedName("FASAT")
    @Expose
    public FASAT fASAT;
    @SerializedName("FATRN")
    @Expose
    public FATRN fATRN;
    @SerializedName("FAMS")
    @Expose
    public FAMS fAMS;
    @SerializedName("FAPU")
    @Expose
    public FAPU fAPU;
    @SerializedName("CHOCDF")
    @Expose
    public CHOCDF cHOCDF;
    @SerializedName("FIBTG")
    @Expose
    public FIBTG fIBTG;
    @SerializedName("SUGAR")
    @Expose
    public SUGAR sUGAR;
    @SerializedName("PROCNT")
    @Expose
    public PROCNT pROCNT;
    @SerializedName("CHOLE")
    @Expose
    public CHOLE cHOLE;
    @SerializedName("NA")
    @Expose
    public NA nA;
    @SerializedName("CA")
    @Expose
    public CA cA;
    @SerializedName("MG")
    @Expose
    public MG mG;
    @SerializedName("K")
    @Expose
    public K k;
    @SerializedName("FE")
    @Expose
    public FE fE;
    @SerializedName("ZN")
    @Expose
    public ZN zN;
    @SerializedName("P")
    @Expose
    public P p;
    @SerializedName("VITA_RAE")
    @Expose
    public VITARAE vITA_RAE;
    @SerializedName("VITC")
    @Expose
    public VITC vITC;
    @SerializedName("THIA")
    @Expose
    public THIA tHIA;
    @SerializedName("RIBF")
    @Expose
    public RIBF rIBF;
    @SerializedName("NIA")
    @Expose
    public NIA nIA;
    @SerializedName("VITB6A")
    @Expose
    public VITB6A vITB6A;
    @SerializedName("FOLDFE")
    @Expose
    public FOLDFE fOLDFE;
    @SerializedName("FOLFD")
    @Expose
    public FOLFD fOLFD;
    @SerializedName("FOLAC")
    @Expose
    public FOLAC fOLAC;
    @SerializedName("VITB12")
    @Expose
    public VITB12 vITB12;
    @SerializedName("VITD")
    @Expose
    public VITD vITD;
    @SerializedName("TOCPHA")
    @Expose
    public TOCPHA tOCPHA;
    @SerializedName("VITK1")
    @Expose
    public VITK1 vITK1;
    @SerializedName("WATER")
    @Expose
    public WATER wATER;
}

class TotalDaily{
    @SerializedName("ENERC_KCAL")
    @Expose
    public ENERCKCAL eNERC_KCAL;
    @SerializedName("FAT")
    @Expose
    public FAT fAT;
    @SerializedName("FASAT")
    @Expose
    public FASAT fASAT;
    @SerializedName("CHOCDF")
    @Expose
    public CHOCDF cHOCDF;
    @SerializedName("FIBTG")
    @Expose
    public FIBTG fIBTG;
    @SerializedName("PROCNT")
    @Expose
    public PROCNT pROCNT;
    @SerializedName("CHOLE")
    @Expose
    public CHOLE cHOLE;
    @SerializedName("NA")
    @Expose
    public NA nA;
    @SerializedName("CA")
    @Expose
    public CA cA;
    @SerializedName("MG")
    @Expose
    public MG mG;
    @SerializedName("K")
    @Expose
    public K k;
    @SerializedName("FE")
    @Expose
    public FE fE;
    @SerializedName("ZN")
    @Expose
    public ZN zN;
    @SerializedName("P")
    @Expose
    public P p;
    @SerializedName("VITA_RAE")
    @Expose
    public VITARAE vITA_RAE;
    @SerializedName("VITC")
    @Expose
    public VITC vITC;
    @SerializedName("THIA")
    @Expose
    public THIA tHIA;
    @SerializedName("RIBF")
    @Expose
    public RIBF rIBF;
    @SerializedName("NIA")
    @Expose
    public NIA nIA;
    @SerializedName("VITB6A")
    @Expose
    public VITB6A vITB6A;
    @SerializedName("FOLDFE")
    @Expose
    public FOLDFE fOLDFE;
    @SerializedName("VITB12")
    @Expose
    public VITB12 vITB12;
    @SerializedName("VITD")
    @Expose
    public VITD vITD;
    @SerializedName("TOCPHA")
    @Expose
    public TOCPHA tOCPHA;
    @SerializedName("VITK1")
    @Expose
    public VITK1 vITK1;
}

class Sub{
    public String label;
    public String tag;
    public String schemaOrgTag;
    public double total;
    public boolean hasRDI;
    public double daily;
    public String unit;
}

class Digest{
    public String label;
    public String tag;
    public String schemaOrgTag;
    public double total;
    public boolean hasRDI;
    public double daily;
    public String unit;
    public List<Sub> sub;
}



