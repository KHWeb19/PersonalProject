<template>
  <v-container>
    <MainCategory></MainCategory>

    <v-row>
      <v-col cols="3">
      <MenuList></MenuList>
      </v-col>
      <v-col cols="9">
        <v-card style="margin-top: 10px; height: 1800px" class="pa-4">
          <DiaryRead :diary="diary" :diaryImg="diaryImg" :diaryNo="diaryNo" @onDelete="onDelete"></DiaryRead>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>

import MainCategory from "@/components/MainCategory";
import MenuList from "@/components/Item/MenuList";
import {mapActions, mapState} from "vuex";
import DiaryRead from "@/components/myPage/DiaryRead";
import axios from "axios";
export default {
  name: "MyPageDiaryRead",
  components: {DiaryRead, MenuList, MainCategory},
  data(){
    return{
      user: localStorage.getItem("session"),
    }
  },
  props: {
    diaryNo: {
      type: String,
      default : ''
    },
  },
  computed: {
    ...mapState(['diary', 'diaryImg'])
  },
  methods: {
    ...mapActions(['fetchDiary', 'fetchDiaryImg']),
    onDelete(){
      let diaryNo = this.diaryNo;

      axios.delete(`http://localhost:7777/myPage/${diaryNo}`)
        .then(() => {
          this.$router.push({name: 'MyPageDiary'})
        })
    }
  },
  mounted() {
    this.fetchDiary(this.diaryNo)
    this.fetchDiaryImg(this.diaryNo)
  }
}
</script>

<style scoped>

</style>