<template>
  <v-container>
    <MainCategory></MainCategory>

    <v-row>
      <v-col cols="3">
        <MenuList></MenuList>
      </v-col>
      <v-col cols="9">
        <v-card style="margin-top: 10px; height: 880px" class="pa-4">
          <DiaryModify :diary="diary" :diaryNo="diaryNo" :diaryImg="diaryImg" @onModify="onModify"></DiaryModify>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import MainCategory from "@/components/MainCategory";
import MenuList from "@/components/Item/MenuList";

import {mapActions, mapState} from "vuex";
import DiaryModify from "@/components/myPage/DiaryModify";
import axios from "axios";
export default {
  name: "MyPageDiaryModify",
  components: {DiaryModify, MenuList, MainCategory},
  props: {
    diaryNo: {
      type: String,
      default: ''
    }
  },
  data(){
    return {
      user: localStorage.getItem("session")
    }
  },
  methods:{
    ...mapActions(['fetchDiary', 'fetchDiaryImg']),
    async onModify(payload){
      const {title, planName, content, diaryImg} = payload;

      await axios.put(`http://localhost:7777/myPage/diaryModify/${this.diaryNo}`,  {title, planName, content})
        .then(() => {
          /*alert ("성공" + res)*/
        })

      let formData = new FormData;

      for(let i = 0; i < diaryImg.length; i++){
        /*alert(diaryImg[i])*/
        formData.append('diaryImgNo', diaryImg[i]);
      }

      await axios.post(`http://localhost:7777/myPage/diaryModifyImg/${this.diaryNo}`, formData)
        .then(() => {
          /*alert('이미지 수정' + res);*/
          this.$router.push({name: 'MyPageDiary'})
        })
    }
  },
  computed: {
    ...mapState(['diary', 'diaryImg'])
  },
  mounted() {
    this.fetchDiary(this.diaryNo)
    this.fetchDiaryImg(this.diaryNo)
  }

}
</script>

<style scoped>

</style>