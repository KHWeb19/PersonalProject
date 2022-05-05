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
      <v-col cols="4">
        <div class="results">
          <div class="place" v-for="(rs, index) in search.results" :key="rs.id" @click="showPlace(rs)" style="margin-bottom: 18px">
            <div>● {{rs.place_name}}</div>
            <div>
              <v-col>{{rs.address_name}}
                <v-btn icon v-if="!indexTitle[index]" @click="savePlace(index, rs)">
                  <v-icon color="black">
                    mdi-cards-heart-outline
                  </v-icon>
                </v-btn>

                <v-btn icon v-else  @click="deleteSavePlace(index, rs)">
                  <v-icon color="red">
                    mdi-cards-heart
                  </v-icon>
                </v-btn>
              </v-col>
            </div>

          </div>
        </div>
      </v-col>

      <v-col cols="8">
        <kakao-map class="kmap" :options="mapOption" :searchMarkerX="searchMarkerX" :searchPlaceUrl="searchPlaceUrl" :searchAddr="searchAddr" :searchMarkerY="searchMarkerY" :searchTitle="searchTitle"></kakao-map>
      </v-col>

    </v-row>

    <v-dialog max-width="800" v-model="showSaveDialog.dialog">
      <v-card>
        <v-row justify="center">
          <v-card-title>
            <span style="font-size: 40px; color: darkolivegreen"><br/>어디 여행지에 저장을 할까요?</span>
          </v-card-title>
        </v-row>

        <v-row justify="center">
        <v-card-text>
          <v-container>
            <v-row justify="center">
              <v-col cols="4" align="center" class="plan"  style="font-size: 30px">&nbsp; &nbsp; 여행 선택 : </v-col>
              <v-col cols="8" align="center" style="font-size: 30px"><p>{{ radioGroup.planName || '여행지 선택 해주세요!' }}</p></v-col>
            </v-row>

            <v-row style="height: 250px">
              <v-col colspan="2" style="margin-left: 30px">
                <v-radio-group v-model="radioGroup" class="large">
                  <v-radio
                      v-for="n in userPlans"
                      :key="n.planNo"
                      :value="n"
                      color="purple">
                    <template v-slot:label>
                      <div style="font-size: 30px; margin-bottom: 25px;">
                        {{ n.planName }}
                      </div>
                    </template>
                  </v-radio>
                </v-radio-group>
              </v-col>
            </v-row>
          </v-container>
        </v-card-text>
        </v-row>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="green darken-1" text @click="showSaveDialog.dialog = false">Close</v-btn>
          <v-btn @click="onSubmit" color="green darken-1">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

  </v-container>
</template>

<script>
import MainCategory from "@/components/MainCategory";
import KakaoMap from "@/components/KakaoMap";
import {mapActions, mapState} from "vuex";
import axios from "axios";
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
      id: localStorage.getItem("session") || "",
      searchMarkerX: [],
      searchMarkerY: [],
      searchTitle: [],
      searchAddr: [],
      searchPlaceUrl: [],
      overlay: null,
      showSaveDialog: {
        dialog: false,
        place: {
          title: '',
          x: 0,
          y: 0,
        }
      },
      radioGroup: 1,
      //indexCheck: ['제주국제공항', '21', '인천국제공항', '대구국제공항', '12', '12', 'true', 'true', 'false', 'true', 'false', 'true'],// 여기에 장소 이름이 저장되어 있어야함.
      indexTitle: [],
    }
  },
  methods:{
    ...mapActions(['fetchUserPlans', 'fetchSearchLikePlaceList']),
    searchPlace(e) {

      this.searchLikePlaceList.forEach((test) => {
        console.log(test);
      })

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

        // indexCheck: ['제주국제공항', true, '인천국제공항', '대구국제공항', false, false, true, true, false, true, false, true],

        for(let i = 0; i < this.searchTitle.length; i++){
          for(let j = 0; j < this.searchLikePlaceList.length; j++) {
            console.log(this.searchLikePlaceList[i])
            console.log(this.searchTitle[j])

            if (this.searchTitle[i] === this.searchLikePlaceList[j].title) {
              this.indexTitle[i] = true;
              console.log(this.indexTitle[i])
              break;
            }
          }

          if(this.indexTitle[i] !== true) {
            this.indexTitle[i] = false;
            console.log(this.indexTitle[i])
          }
        }
        console.log(this.searchLikePlaceList)
        console.log(this.searchTitle)
        console.log(this.indexTitle)
      })
    },
    showPlace(place){
      console.log(place)
      this.mapOption.center = {
        lat: place.y,
        lng: place.x
      }
    },
    savePlace(index, result){
      console.log("x: " + result.x + ", y: " + result.y);
      //alert(this.searchLikePlaceList[index] === result.place_name)

      this.showSaveDialog.place.title = result.place_name;
      this.showSaveDialog.place.x = result.x;
      this.showSaveDialog.place.y = result.y;

      this.showSaveDialog.dialog = true;

      this.$set(this.searchLikePlaceList, index, !this.searchLikePlaceList[index])
      /*alert(this.searchLikePlaceList[index])*/
    },
    deleteSavePlace(index){
      //alert(result);
      this.$set(this.indexTitle, index, !this.indexTitle[index]);
    },
    onSubmit(){
      this.showSaveDialog.dialog = false;
      let planNo = this.radioGroup.planNo;
      let id = this.id;
      let placeTitle = this.showSaveDialog.place.title;
      let placeX = this.showSaveDialog.place.x;
      let placeY = this.showSaveDialog.place.y;

     /* alert("planName: " + this.radioGroup.planNo + ", " + this.showSaveDialog.place.title + ", x: " + placeX + ", y : " + placeY)
      console.log("planName: " + this.radioGroup.planNo + ", " + this.showSaveDialog.place.title + ", x: " + placeX + ", y : " + placeY)*/

      axios.post('http://localhost:7777/map/savePlace', {planNo, id, placeTitle, placeX, placeY} )
        .then(() => {
          //alert(res + '성공!')
        })
    }
  },
  computed: {
    ...mapState(['userPlans', 'searchLikePlaceList'])
  },
  mounted() {
    this.fetchUserPlans(this.id)
    this.fetchSearchLikePlaceList(this.id)
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
v-radio{
  width: 100px;
  font-size: 100px;
}

</style>