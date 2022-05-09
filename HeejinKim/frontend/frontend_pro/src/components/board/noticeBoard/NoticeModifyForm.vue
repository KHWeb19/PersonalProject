<template>
  <v-container>
    <v-form @submit.prevent="onSubmit">

        <table>
          <v-row justify="center">
            <v-col cols="2" class="label mt-5 mr-3"  >Title</v-col>
            <v-col>
              <v-text-field color="grey" type="text" v-model="title"/>
            </v-col>
          </v-row>

          <v-row>
            <v-col cols="12">
              <v-textarea cols="80" rows="20" outlined color="grey"
              style="white-space:pre-line" class="mt-3"
              v-model="content">
              </v-textarea>
            </v-col>
          </v-row>

          <v-row wrap>
            <router-link :to="{ name: 'NoticeReadPage',
              params: { boardNo: noticeBoard.boardNo.toString() } }" 
              style=" text-decoration:none"><v-btn color="#c2c1c0" text>
                <v-icon class="deleteIcon"> mdi-keyboard-backspace </v-icon></v-btn></router-link>
            <v-btn type="submit" class="submitBtn" color="#dbc34d" >
              <v-icon class="submitIcon" color="white"> mdi-file-check </v-icon></v-btn>
          </v-row>

        </table>

    </v-form>  
   </v-container>
</template>

<script>
export default {
  name: "NoticeModifyForm",
  props: {
    noticeBoard: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      title: "",
      content: "",
    }
  },
  methods: {
    onSubmit() {
      const { title, content } = this
      this.$emit("submit", { title, content })
    },
  },
  created() {
    this.title = this.noticeBoard.title
    this.content = this.noticeBoard.content
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poiret+One&display=swap');
.label{
    font-size: 20pt;
    margin-right:5%;
    text-align: center;
    font-family: 'Poiret One', cursive;
}
table{ 
    background-color: #f3f3f3;;
    padding: 5% 10% 5% 10%;
    margin-left:auto;
    margin-right:auto;
      
}
   
.v-text-field, .v-textarea, #files{
    font-family: 'Noto Sans KR', sans-serif;
}
.submitBtn{
  margin-left:250px;
}
</style>