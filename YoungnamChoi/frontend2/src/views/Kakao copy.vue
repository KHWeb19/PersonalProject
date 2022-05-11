<template>
  <div>
    <h3>맛집 검색</h3>
    <div class="controll">
      <button @click="zoom(1)">
        <span class="material-icons"> zoom_in </span>
      </button>
      <button @click="zoom(-1)">
        <span class="material-icons"> zoom_out </span>
      </button>
    </div>

    <div class="map-area">
      <div class="searchbox">
        <div>
          <input type="text" value="수유역 맛집" @keyup.enter="searchPlace" />
        </div>
        <div class="results">
          <div
            class="place"
            v-for="rs in search.results"
            :key="rs.id"
            @click="showPlace(rs)"
          >
            <h4>{{ rs.place_name }}</h4>
            <div class="addr">{{ rs.address_name }}</div>
          </div>
        </div>
      </div>
      <KakaoMap class="kmap" :options="mapOption" />
    </div>
    <!-- <div class="kmap" ref="map"></div> -->
  </div>
</template>

<script>
import KakaoMap from "@/components/map/KakaoMap.vue";

export default {
  components: { KakaoMap },

  name: "Kakao",
  data() {
    return {
      mapOption: {
        center: {
          lat: 33.450701,
          lng: 126.570667,
        },
        level: 8,
      },
      search: {
        keyword: null,
        pgn: null,
        results: [],
      },
    };
  },
  mounted() {},
  methods: {
    searchPlace(e) {
      const keyword = e.target.value.trim();
      if (keyword.lenght === 0) {
        return;
      }
      const ps = new window.kakao.maps.services.Places();
      ps.keywordSearch(keyword, (data, status, pgn) => {
        this.search.keyword = keyword;
        this.search.pgn = pgn;
        this.search.results = data;
      });
    },
    zoom(delta) {
      const level = Math.max(3, this.mapOption.level + delta); // min level 3
      this.mapOption.level = level;
    },
    showOnMap(harbor) {
      // console.log("[center]", harbor);
      this.mapOption.center = {
        lat: harbor.lat,
        lng: harbor.lng,
      };
    },
    showPlace(place) {
      console.log(place);
      this.mapOption.center = {
        lat: place.y,
        lng: place.x,
      };
    },
  },
};
</script>

<style lang="scss">
button {
  border: 1px solid transparent;
  padding: 6px;
  background-color: #efefefdd;
  border-radius: 6px;
  &:hover {
    background-color: #ddd;
    border-color: #ddd;
    cursor: pointer;
  }
  &:active {
    background-color: #aaa;
    border-color: #aaa;
  }
}
.map-area {
  display: flex;
  .searchbox {
    .place {
      padding: 0.5px;
      &:hover {
        background-color: rgba(240, 248, 255, 0.657);
      }
      h4 {
        margin: 0;
      }
    }
  }
}
.kmap {
  flex: 1 1 auto;
  height: 600px;
}
</style>
