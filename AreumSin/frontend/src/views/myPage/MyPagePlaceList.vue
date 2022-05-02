<template>
  <v-container>
    <MainCategory></MainCategory>

    <v-row>
      <v-col cols="3">
        <MenuList></MenuList>
      </v-col>
      <v-col cols="9">
        <v-card style="margin-top: 10px; height: 880px" class="pa-4">
          <SavePlaceList :savePlace="savePlace"></SavePlaceList>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import MainCategory from "@/components/MainCategory";
import MenuList from "@/components/Item/MenuList";
import SavePlaceList from "@/components/myPage/SavePlaceList";
import {mapActions, mapState} from "vuex";
export default {
  name: "MyPagePlaceList",
  components: {SavePlaceList, MenuList, MainCategory},
  data(){
    return{
      user: localStorage.getItem("session")
    }
  },
  methods: {
    ...mapActions(['fetchSavePlace'])
  },
  computed: {
    ...mapState(['savePlace'])
  },
  mounted() {
    this.fetchSavePlace(this.user)
  }
}
</script>

<style scoped>

</style>