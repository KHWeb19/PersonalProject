<template>
  <div ref="map"></div>
</template>

<script>
let kakao = window.kakao
export default {
  name: "KakaoMap",
  props: ['options', 'searchMarkerX', 'searchMarkerY', 'searchTitle', 'searchPlaceUrl', 'searchAddr'],
  data() {
    return {
      mapInstance: null,
      markerInstance: null,
      markers: [],
      iwContent: 'hello!',
      overlay: null,
      infoWindow: null,
    }
  },
  mounted() {
    kakao = kakao || window.kakao;

    let container = this.$refs.map;

    const {center, level} = this.options;
    this.mapInstance = new kakao.maps.Map(container, {
      center: new kakao.maps.LatLng(center.lat, center.lng),
      level,
    })

  },
  watch: {
    "options.center"(cur) {
      console.log(cur.lat)
      this.mapInstance.setCenter(new kakao.maps.LatLng(cur.lat, cur.lng))
    },
    "searchMarkerX"() {
      this.add();
    }

  },
  methods: {
    showMarkers(map) {
      for (let i = 0; i < this.markers.length; i++) {
        this.markers[i].setMap(map);
      }
      this.markers = []
    },
    add() {
      this.showMarkers(null)
      for (let i = 0; i < this.searchMarkerX.length; i++) {
        this.markerInstance = new kakao.maps.Marker({
          position: new kakao.maps.LatLng(this.searchMarkerY[i], this.searchMarkerX[i])
        })

        this.markerInstance.setMap(this.mapInstance);
        this.markers.push(this.markerInstance);

        this.showAt(i, this.mapInstance)
      }
    },
    showAt(i, map){
      this.infowindow = new kakao.maps.InfoWindow({
        content: '<div style="height: 100%; width: 250px">' +
            '<div class="close" onclick="closeOverlay()" title="닫기" style="height: 100%;">' +
              '<div style="font-size: 27px">' + this.searchTitle[i]+ '</div>' +
            '</div>'+
              '<div>' + this.searchAddr[i]+ '</div>'+
              '<div>' + '<div><a href="' + this.searchPlaceUrl[i]+ '" target="_blank" class="link">홈페이지</a></div>'+ '</div>'+
            '</div>',
        removable : true,
      });

      kakao.maps.event.addListener(this.markerInstance, 'click', this.makeOverListener(map, this.markerInstance, this.infowindow));
    },
    makeOverListener(map, marker, infowindow) {
      return function() {
        infowindow.open(map, marker);
      };
    },
  },
}
</script>

<style scoped>
.kmap{
  width: 100%;
  height: 700px;
}
</style>