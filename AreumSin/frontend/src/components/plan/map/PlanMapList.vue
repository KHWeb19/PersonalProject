<template>
  <v-container>
    <div class="kmap" ref="map"></div>
  </v-container>
</template>

<script>
let kakao = window.kakao
import {mapActions, mapState} from "vuex";

export default {
  name: "PlanMapList",
  props: {
    planNo: {
      type: String,
    }
  },
  data(){
    return{
      mapInstance: null,
      markInstance: null,
      infowindow: null,
      markers: [],
    }
  },
  mounted() {
    this.fetchMapMarkList(this.planNo)
    kakao = kakao || window.kakao;
    console.log(this.$refs.map);

    let container = this.$refs.map;

    /*let options = {
      center : new kakao.maps.LatLng(33.450701, 126.570667),
      level: 6,
    }*/

    //alert(this.markLikePlaceList[0].x)
    let startX = this.markLikePlaceList[0].x;
    let startY = this.markLikePlaceList[0].y;

    //alert(startX + ", " + startY);

    this.mapInstance = new kakao.maps.Map(container, {
      center : new kakao.maps.LatLng(startY, startX),
      level: 10,
    });

    for(let i = 0; i < this.markLikePlaceList.length; i++){ // for문
      console.log('!!!!!!!!!!!!!!!!!!!!!!!!!!!!!' + i + '!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!')
      console.log('x좌표: ' +this.markLikePlaceList[i].x)
      console.log('y좌표: ' +this.markLikePlaceList[i].y)
      console.log('title: ' +this.markLikePlaceList[i].title)

      this.markInstance = new kakao.maps.Marker({
        position: new kakao.maps.LatLng(this.markLikePlaceList[i].y, this.markLikePlaceList[i].x),
        //clickable: true
    })

      this.markInstance.setMap(this.mapInstance);
      this.markers.push(this.markInstance);

      this.showAt(i,this.mapInstance)
    } // for

    console.log(this.mapInstance)
  },
  computed: {
    ...mapState(['markLikePlaceList'])
  },
  methods: {
    ...mapActions(['fetchMapMarkList']),
    showAt(i){
      this.infowindow = new kakao.maps.InfoWindow({
        content: '<div style="height: 100%; width: 250px">' +
            '<div class="close" onclick="closeOverlay()" title="닫기" style="height: 100%;">' +
            '<div style="font-size: 27px">' + this.markLikePlaceList[i].title+ '</div>' +
            '</div></div>',
        removable : true,
      });

      /*kakao.maps.event.addListener(this.markerInstance, 'click', this.makeOverListener(map, this.markInstance, this.infowindow));*/
      kakao.maps.event.addListener(this.markInstance, 'click', this.makeOverListener(this.mapInstance, this.markInstance, this.infowindow));
    },
    makeOverListener(map, marker, infowindow) {
      return function() {
        infowindow.open(map, marker);
      };
    },
  }
}
</script>

<style scoped>
.kmap{
  width: 100%;
  height: 800px;
}
</style>