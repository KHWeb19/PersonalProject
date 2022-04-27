<template>
  <v-container>
    <MainCategory/>

    <v-row justify="center">
      <v-col cols="6">
        <input id="searchBox" type="text" @keyup.enter="searchPlace"/>
        <!--        <v-text-field dense outlined label="장소 검색"
                      full-width :style="{marginTop:'10px', align: 'center'}"/>-->
      </v-col>
    </v-row>

    <v-row>
      <v-col cols="3">
        <div class="results">
          <div class="place" v-for="rs in search.results" :key="rs.id" @click="showPlace(rs)" style="margin-bottom: 18px">
            ● {{rs.place_name}}<br/>
            {{rs.address_name}}
            <v-btn style="background-color:transparent;"><v-icon>mdi-cards-heart-outline</v-icon></v-btn>
          </div>
        </div>
      </v-col>
<!--      <div class="map-wrapper" ref="kakaomap" style="width: 100%; height: 600px"></div>-->
      <v-col cols="9">
        <kakao-map class="kmap" :options="mapOption" :searchMarkerX="searchMarkerX" :searchPlaceUrl="searchPlaceUrl" :searchAddr="searchAddr" :searchMarkerY="searchMarkerY" :searchTitle="searchTitle"></kakao-map>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import MainCategory from "@/components/MainCategory";
import KakaoMap from "@/components/KakaoMap";
export default {
  name: "SearchView",
  components: {KakaoMap, MainCategory},
  data(){
    return{
      mapOption: {
        center: {
          lat: 33.450701,
          lng: 126.570667,
        },
        level: 8
      },
      search: {
        keyword: null,
        pagination: null,
        results: null,
      },
      searchMarkerX: [],
      searchMarkerY: [],
      searchTitle: [],
      searchAddr: [],
      searchPlaceUrl: [],
      overlay: null
    }
  },
  mounted() {

  },
  methods:{
    searchPlace(e) {
      console.log(e.target.value);
      const keyword = e.target.value.trim();
      if (keyword.length === 0){
        return;
      }

      const ps = new window.kakao.maps.services.Places();

      this.searchMarkerX = [];
      this.searchMarkerY = [];

      // 키워드로 검색 후 콜백 함수가 data, status, pagination
      ps.keywordSearch(keyword, (data, status, pagination) => {
        console.log(data)
        console.log(status)

        for(let i = 0; i < data.length; i++){
          this.searchMarkerX.push(data[i].x);
          this.searchMarkerY.push(data[i].y);
          this.searchTitle.push(data[i].place_name);
          this.searchAddr.push(data[i].address_name);
          this.searchPlaceUrl.push(data[i].place_url);

          console.log("x: "+data[i].x + ", y: " + data[i].y +"searchMarker size" + this.searchMarkerX.length)
        }
        this.search.keyword = keyword;
        this.search.pagination = pagination;
        this.search.results = data;
      })
    },
    showPlace(place){
      console.log(place)
      this.mapOption.center = {
        lat: place.y,
        lng: place.x
      }
    },
  }
}
</script>

<style scoped>
.results{
  font-size: 25px;
  flex: 1 1 auto;
  overflow-y: scroll;
  width: 100%;
  height: 700px;
}
#searchBox{
  margin-top: 30px;
  border: #27559a solid 5px;
  width: 100%;
  height: 50px;
  font-size: 40px;
  border-radius: 15px;
}
</style>