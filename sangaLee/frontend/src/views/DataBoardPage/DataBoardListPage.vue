<template>
      <div class="mainbg">
    <v-navigation-drawer app fixed permanent :width="150">
      <side-bar/>
    </v-navigation-drawer>

    <h1>자료 게시판</h1>

      <v-navigation-drawer app fixed permanent :width="350" right>
        <right-bar/>
      </v-navigation-drawer>
    
    <!-- 게시물 작성 버튼 
    <router-link :to="{ name: 'DataBoardRegisterPage' }">
        게시물 작성
    </router-link>-->

    <!-- 게시물 목록 -->
    <br>
    <br>
        <label>
            <input type="file" id="files" ref="files" 
                    multiple v-on:change="handleFileUpload()"/>
                    <button class="filebtn" v-on:click="submitFiles()">Upload</button>
        </label>
        <br>
        <br>
        <label>
            <input type="file" id="files2" ref="files2" 
                    multiple v-on:change="handleFileUpload2()"/>
                    <button class="filebtn" v-on:click="submitFiles2()">Upload</button>
        </label>
        <br>
        <br>
        <label>
            <input type="file" id="files3" ref="files3" 
                    multiple v-on:change="handleFileUpload3()"/>
                    <button class="filebtn" v-on:click="submitFiles3()">Upload</button>
        </label>
        <br>
        <br>
        <label>
            <input type="file" id="files4" ref="files4" 
                    multiple v-on:change="handleFileUpload4()"/>
                    <button class="filebtn" v-on:click="submitFiles4()">Upload</button>
        </label>
        <br>
        <br>
        <label>
            <input type="file" id="files5" ref="files5" 
                    multiple v-on:change="handleFileUpload5()"/>
                    <button class="filebtn" v-on:click="submitFiles5()">Upload</button>
        </label>
        

  </div>
</template>

<script>
import SideBar from '../../components/Layout/SideBar.vue'
import RightBar from '../../components/Layout/RightBar.vue'
import DataBoardList from '../../components/DataBoard/DataBoardList.vue'
import axios from 'axios'

export default {
    components: {
        SideBar,
        DataBoardList,
        RightBar
    },
    data () {
      return {
        files: '',
        files2: '',
        files3: '',
        files4: '',
        files5: '',
        response: ''
      }
    },
    methods: {
      handleFileUpload () {
        this.files = this.$refs.files.files
      },
      handleFileUpload2 () {
        this.files = this.$refs.files2.files
      },
      handleFileUpload3 () {
        this.files = this.$refs.files3.files
      },
      handleFileUpload4 () {
        this.files = this.$refs.files4.files
      },
      handleFileUpload5 () {
        this.files = this.$refs.files5.files
      },
      submitFiles () {
            let formData = new FormData()

            for (let idx = 0; idx < this.files.length; idx++) {
                formData.append('fileList', this.files[idx])
            }

            axios.post('http://localhost:7777/file/uploadImg', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
            .then (res => {
                alert('처리 결과: ' + res.data)
            })
            .catch (res => {
                alert('처리 결과: ' + res.message)
            })
        },
        submitFiles2 () {
            let formData = new FormData()

          let fileinfo = {
            price: 50000,
            test: "test"
          }

          for (let idx = 0; idx < this.files2.length; idx++) {
            formData.append('fileList', this.files2[idx])
          }

          formData.append(
              "info",
              new Blob([JSON.stringify(fileinfo)], { type: "application/json" })
          );

            axios.post('http://localhost:7777/file/uploadImgWithString', formData)
            .then (res => {
                alert('처리 결과: ' + res.data)
            })
            .catch (res => {
                alert('처리 결과: ' + res.message)
            })
        }
    }
}
</script>

<style scoped>
.mainbg {
  height: 100vh;
  padding: 55px;
  color: #6768ab;
}
button {
  margin-left: 500px;
}
</style>