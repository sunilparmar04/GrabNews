package in.grabnews.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import in.grabnews.data.DataManager;
import in.grabnews.data.model.db.Country;

public final class NewsRequest {

    private NewsRequest() {
        // This class is not publicly instantiable
    }

    public static class NewsParamsRequest {

        @Expose
        @SerializedName("country")
        private String countryCode;

        @Expose
        @SerializedName("category")
        private String category;


        public NewsParamsRequest(DataManager dataManager) {

            Country country = dataManager.getSelectedCountry(Country.class);
            if (country != null && !country.countryName.isEmpty()) {
                this.countryCode = country.countryCode;
            } else {
                this.countryCode = "in";
            }

            this.category = dataManager.getSelectedCategory();
        }

    }

}
