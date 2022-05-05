<template>
  <v-container>
    <v-row>
    <table border="1" width="100%">
      <tr>
        <td>제목</td>
        <td><input type="text" value="제목작성해야해" style="width: 100%" v-model="title"></td>
      </tr>

      <tr>
        <td>사진 업로드</td>
        <td>
          <v-btn icon @click="onClickFile"><v-icon>mdi-folder-image</v-icon></v-btn>
          {{fileLength}}
        </td>
        <input type=file class="file-input" id="files" ref="files" multiple v-on:change="fileUpload()">
      </tr>

      <tr>
        <td>여행 선택</td>
        <td>
          <v-chip-group v-model="selection" mandatory active-class="primary--text">
            <v-chip v-for="tag in userPlans" :key="tag.planNo">
              {{ tag.planName }}
            </v-chip>
          </v-chip-group>
        </td>
      </tr>

      <tr>
        <td>내용</td>
        <td><textarea style="width: 100%; height: 620px" v-model="content"></textarea></td>
      </tr>
    </table>
    </v-row>

    <v-row justify="end" style="margin-top: 25px">
      <v-btn class="green white--text" @click="writeDiary" style="width: 150px; height: 50px">저장</v-btn>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  name: "KeepADiary",
  props: {
    userPlans: {
      type: Array,
    }
  },
  data(){
    return{
      icon: 'mdi-emoticon',
      selection: 1,
      fileLength: 0,
      title: '',
      content: '',
      user: localStorage.getItem("session")
    }
  },
  methods: {
    onClickFile(){
      this.$refs.files.click()
    },
    fileUpload(){
      this.files = this.$refs.files.files;
      this.fileLength = this.files.length;
    },
    writeDiary(){

      if(this.fileLength === 0 ){
        alert("사진을 하나 이상 골라주세요!")
      }else {
        let num = this.selection;
        let planName = this.userPlans[num].planName;

        let formData = new FormData;

        for (let i = 0; i < this.fileLength; i++) {
          console.log(this.files[i])
          formData.append('fileList', this.files[i]);
        }

        formData.append('title', this.title)
        formData.append('content', this.content)
        formData.append('planName', planName);

        axios.post(`http://localhost:7777/myPage/writeDiary/${this.user}`, formData, {
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        })
            .then((res) => {
              this.response = res.data
            })
            .catch((res) => {
              this.response = res.message
            })

        //alert('처리 완료!')
        this.$router.push({name: 'MyPageDiary'})
      }
    }
  }
}
</script>

<style scoped>
table{
  border-collapse : collapse;
}
td{
  font-size: 30px;
}
.file-input {
  display: none;
}
</style>