<template>
  <v-container>
    <v-card>
      <v-row>
        <v-col>제목</v-col>
        <v-col>{{boardRead.title}}</v-col>
      </v-row>

      <v-row>
        <v-col>장소</v-col>
        <v-col>{{boardRead.place}}</v-col>
      </v-row>

      <v-row>
        <v-col>작성자</v-col>
        <v-col>{{boardRead.writer}}</v-col>
      </v-row>

      <v-row>
        <v-col>내용</v-col>
        <v-col>{{boardRead.boardContent}}</v-col>
      </v-row>

      <v-row v-for="(boardImg,index) in boardReadImg" :key="index">
        <v-col>
          <v-img :src="require(`@/assets/uploadImg/${boardImg.imgSrc}`)" id="img"></v-img>
        </v-col>
      </v-row>

    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "BoardReadImgPage",
  props: {
    boardRead: {
      type: Object,
      required: true
    },
    boardReadImg: {
      type: Array,
    }
  }
}
</script>

<style scoped>

</style>