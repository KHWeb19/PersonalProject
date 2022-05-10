<template>
  <v-container>
    <main-category></main-category>

    <v-row>
      <v-col>
        <plan-map-list :planNo="planNo"></plan-map-list>
      </v-col>


      <v-col cols="4">
        <div style="margin-top: 30px">
          <v-card height="350px">
            <div id="likePlaceList">
              <v-card-title>
                <v-row justify="center" style="font-size: 25px; margin-top: 3px">
                  방문할 장소 리스트
                </v-row>
              </v-card-title>

              <v-card-text style="margin-top: 30px">
                <v-row v-for="(pList, index) in paginatedData" :key="pList.favoritePlaceNo" style="font-size: 25px; margin-bottom: 3px; align-items: center">
                  {{index+1}}: {{pList.title}}&nbsp;<v-btn icon @click="savePlace(pList.favoritePlaceNo)"><v-icon>mdi-plus-circle-outline</v-icon></v-btn>
                </v-row>
              </v-card-text>
            </div>

            <v-row id="pageNum" justify="center">
              <v-btn :disabled="likePlacePageNum === 0" @click="prevPage" icon><v-icon>mdi-chevron-left</v-icon></v-btn>
              <span id="page">&nbsp;&nbsp;{{likePlacePageNum +1 }}  /  {{pageCount}}&nbsp;&nbsp;</span>
              <v-btn :disabled="likePlacePageNum >= pageCount -1" @click="nextPage" icon><v-icon>mdi-chevron-right</v-icon></v-btn>
            </v-row>
          </v-card>
        </div>

        <v-card height="350px" style="margin-top: 50px">
          <div id="saveLikePlaceList">
            <v-card-title>
              <v-combobox
                  style="font-size: 30px"
                  v-model="select"
                  :items="dates"
                  label="Combobox"
                  outlined
                  dense
              ></v-combobox>
            </v-card-title>

            <v-card-text style="margin-top: 3px">
              <v-row v-for="test in savePaginatedData" :key="test.favoritePlaceNo" style="font-size: 25px; margin-bottom: 5px">
                &nbsp;&nbsp;{{test.title}}
              </v-row>
            </v-card-text>
          </div>

          <v-row id="pageSaveDay" justify="center">
            <v-btn :disabled="saveLikePlacePageNum === 0" @click="savePrevPage" icon><v-icon>mdi-chevron-left</v-icon></v-btn>
            <span id="pages">&nbsp;&nbsp;{{saveLikePlacePageNum +1 }}  /  {{savePageCount}}&nbsp;&nbsp;</span>
            <v-btn :disabled="saveLikePlacePageNum >= savePageCount -1" @click="saveNextPage" icon><v-icon>mdi-chevron-right</v-icon></v-btn>
          </v-row>

        </v-card>
      </v-col>
    </v-row>


    <v-dialog max-width="800" v-model="saveFavoriteDialog.dialog">
      <v-card>
        <v-row justify="center">
          <v-card-title>
            <span style="font-size: 40px; color: darkolivegreen"><br/>어떤날에 저장할까요?</span>
          </v-card-title>
        </v-row>

        <v-row justify="center">
          <v-card-text>
            <v-container>
              <v-row justify="center">
                <v-col cols="4" align="center" class="plan"  style="font-size: 30px">&nbsp; &nbsp; 여행 선택 : </v-col>
                <v-col cols="8" align="center" style="font-size: 30px"><p>{{ radioGroup || '여행 날짜를 선택 해주세요!' }}</p></v-col>
              </v-row>

              <v-row style="height: 250px">
                <v-col colspan="2" style="margin-left: 30px">
                  <v-radio-group v-model="radioGroup" class="large">
                    <v-radio
                        v-for="n in dates"
                        :key="n"
                        :value="n"
                        color="purple">
                      <template v-slot:label>
                        <div style="font-size: 30px; margin-bottom: 25px;">
                          {{ n }}
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
          <v-btn color="green darken-1" text @click="saveFavoriteDialog.dialog = false">Close</v-btn>
          <v-btn @click="onSubmit" color="green darken-1">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
import PlanMapList from "@/components/plan/map/PlanMapList";
import MainCategory from "@/components/MainCategory";
import {mapActions, mapState} from "vuex";
import axios from "axios";
import {FETCH_PLACE_LIST_DAY} from "@/store/mutation-types";

export default {
  name: "PlanMapListView",
  components: {MainCategory, PlanMapList},
  props: {
    planNo: {
      type: String,
      default: ''
    },
    dates: {
      type: Array,
      default: null
    }
  },
  data(){
    return{
      likePlacePageNum: 0,
      likePlacePageSize: 5,
      saveLikePlacePageNum: 0,
      saveLikePlacePageSize: 5,
      select: null,
      saveFavoriteDialog: {
        dialog: false,
        savePlaceNo: 0
      },
      radioGroup: '',
    }
  },
  methods: {
    ...mapActions(['fetchLikePlaceList']),
    savePlace(savePlaceNo){
      this.saveFavoriteDialog.savePlaceNo = savePlaceNo;
      this.saveFavoriteDialog.dialog = true;
    },
    nextPage () {
      this.likePlacePageNum += 1;
    },
    prevPage () {
      this.likePlacePageNum -= 1;
    },
    savePrevPage () {
      this.saveLikePlacePageNum -= 1;
    },
    saveNextPage () {
      this.saveLikePlacePageNum += 1;
    },
    onSubmit(){
      let favoritePlaceNo = this.saveFavoriteDialog.savePlaceNo;
      let day = this.radioGroup;

      //alert(favoritePlaceNo + ", " + day)
      axios.post('http://localhost:7777/planDay/savePlaceDay', {favoritePlaceNo, day})
          .then((res) => {
            console.log(res + '성공')
            //this.$router.go();
            this.saveFavoriteDialog.dialog = false
          })
    }
  },
  computed: {
    ...mapState(['mapLikePlaceList','placeLikeDayList']),
    pageCount() {
      let listLeng = this.mapLikePlaceList.length,
          listSize = this.likePlacePageSize,
          page = Math.floor(listLeng / listSize);

      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    paginatedData() {
      const start = this.likePlacePageNum * this.likePlacePageSize,
          end = start + this.likePlacePageSize;
      return this.mapLikePlaceList.slice(start, end);
    },
    savePageCount() {
      let listLeng = this.placeLikeDayList.length,
          listSize = this.saveLikePlacePageSize,
          page = Math.floor(listLeng / listSize);

      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    savePaginatedData() {
      const start = this.saveLikePlacePageNum * this.saveLikePlacePageSize,
          end = start + this.saveLikePlacePageSize;
      return this.placeLikeDayList.slice(start, end);
    }
  },
  mounted() {
    this.fetchLikePlaceList(this.planNo)
  },
  watch: {
    select: function (test){
      let planNo = this.planNo;
      let day = test;
      //alert(day + ", " +planNo)
      axios.post('http://localhost:7777/planDay/mapPlaceListDay', {planNo, day})
            .then((res) => {
              this.$store.commit(FETCH_PLACE_LIST_DAY, res.data)
            })
    }
  }
}
</script>

<style scoped>
#likePlaceList{
  height: 200px;
  min-height: 100%;
}
#pageNum{
  height: 30px;
  position : relative;
  transform : translateY(-100%);
}
#saveLikePlaceList{
  height: 150px;
  min-height: 100%;
}
#pageSaveDay{
  height: 30px;
  position : relative;
  transform : translateY(-100%);
}
</style>