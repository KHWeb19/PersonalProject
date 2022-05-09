<template>
  <v-container>
    <v-form @submit.prevent="onSubmit">
          <table>
            <v-row justify="center">
                <v-col cols="2" class="label mt-5 mr-3"  >Title</v-col>
                <v-col>
                  <v-text-field color="#e3c832" type="text" v-model="title"/>
                </v-col>
              </v-row>

              <v-row>
                <v-col cols="12">
                  <v-textarea cols="80" rows="20" outlined color="grey"
                  style="white-space:pre-line" placeholder="Enter content" class="mt-3"
                  v-model="content">
                  </v-textarea>
                </v-col>
              </v-row>

              <v-row wrap>
                <v-btn @click="cancel" class="cancleBtn" color="grey" text>
                  <v-icon class="listIcon" justify="center"> mdi-keyboard-backspace</v-icon></v-btn>
                <v-btn type="submit" class="writeBtn" color="black" dark>submit</v-btn>
              </v-row>
          </table>
    </v-form>  
  </v-container>
</template>

<script>
export default {
  name: "NoticeRegisterForm",
  data() {
    return {
      title: "",
      content: "",
      userInfo: JSON.parse(localStorage.getItem("userInfo")),
    };
  },
  methods: {
    onSubmit() {
      this.writer = this.userInfo.userId;
      const { title, content, writer } = this;
      this.$emit("submit", { title, content, writer });
    },
    cancel (){
            this.$router.push('/noticeList')
        },
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poiret+One&display=swap');
.label{
    font-size: 17pt;
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
   
.cancleBtn {
    position: relative;
    margin-top:1%;   
}
.writeBtn {
     margin-top:1%;  
      margin-left:210px;    
}
.imageDeleteBtn{
    zoom:0.8;
    margin-left:3%;
    
}
</style>