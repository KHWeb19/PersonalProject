<template>
  <v-container>
    <MainCategory></MainCategory>

    <v-row>
      <v-col cols="3">
        <MenuList></MenuList>
      </v-col>
      <v-col cols="9">
        <v-card style="margin-top: 10px; height: 880px" class="pa-4">
          <DiaryPageList :diaryList="diaryList"></DiaryPageList>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import MainCategory from "@/components/MainCategory";
import MenuList from "@/components/Item/MenuList";
import DiaryPageList from "@/components/myPage/DiaryPageList";
import {mapActions, mapState} from "vuex";
export default {
  name: "MyPageDiary",
  components: {DiaryPageList, MenuList, MainCategory},
  data(){
    return {
      user: localStorage.getItem("session")
    }
  },
  methods:{
    ...mapActions(['fetchDiaryList'])
  },
  computed: {
    ...mapState(['diaryList'])
  },
  mounted() {
    this.fetchDiaryList(this.user)
  }

}
</script>

<style scoped>

</style>