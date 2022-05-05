<template>
  <v-container>

    <v-row style="height: 100px">
      <input type="text" style="border: black solid 1px; width: 70%; height: 100px; font-size: 30px" v-model="content">
      <v-col>
      <v-row>
        <v-btn icon @click="onClickFile"><v-icon>mdi-folder-image</v-icon></v-btn>
        <input type=file class="file-input" id="files" ref="files" multiple v-on:change="fileUpload()">
      </v-row>
        <v-row style="margin-left: 5px">
          {{fileLength}}
        </v-row>
      </v-col>
      <v-btn @click="sendContent" style="width: 25%; height: 100px; font-size: 30px; background-color: darkolivegreen; color: white">
        확인
      </v-btn>
    </v-row>
  </v-container>


</template>

<script>
import axios from "axios";

export default {
  name: "WriteContent",
  props: ['day'],
  data(){
    return{
      content: '',
      id: localStorage.getItem('session'),
      planNo: localStorage.getItem('planNo'),
      files: '',
      fileLength: 0,
    }
  },
  methods:{
    sendContent(){

      if(this.files.length === 0){
        const {content} = this;
        let id = this.id;
        let planNo = this.planNo;
        let day = this.day;

        axios.post('http://localhost:7777/planDay/dayNoImg', {id, planNo, day, content})
            .then(() => {
              //alert('성공' + res)
              this.$router.go();
            })

      }else {
        let formData = new FormData;

        for (let i = 0; i < this.files.length; i++) {
          console.log(this.files[i])
          formData.append('fileList', this.files[i])
        }

        formData.append('id', this.id)
        formData.append('planNo', this.planNo)
        formData.append('day', this.day)
        formData.append('content', this.content)

        //alert('day: ' + this.day)
        console.log(this.day)

        axios.post('http://localhost:7777/planDay/day', formData, {
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        })
            .then((res) => {
              this.response = res.data
              this.$router.go();
            })
            .catch((res) => {
              this.response = res.message
            })

        //alert('처리 완료!')

      }
    },
    onClickFile(){
      this.$refs.files.click()
    },
    fileUpload(){
      this.files = this.$refs.files.files;
      this.fileLength = this.files.length;
    }
  }
}
</script>

<style scoped>
.file-input {
  display: none;
}
</style>