<template>
    <v-container>
        <v-row column wrap justify="center">
            <v-col v-for="project in searchList" :key="project.projectNo" lg="3" sm="6">
            <v-card width="280" height="435" class="mx-auto">
            <router-link :to="{ name: 'ProjectReadPage',
                                        params: { projectNo: project.projectNo.toString() }}">
              <v-img
                :src="require(`@/assets/back/projectBoard/${project.fileName}`)"
                class="thum"
              ></v-img>
            </router-link>
            <v-divider />
            <v-card-title class="pl-5 pt-5"> 
                    {{ project.projectName }} 
            </v-card-title>
            <v-card-actions>
              <v-card-text class="pl-3 pb-3 pt-0">
                  <v-icon> mdi-crown </v-icon>&nbsp;{{ project.writer }}
              </v-card-text>
                <v-card-text class="pl-3 pb-3 pt-0">
                    <v-icon>mdi-account-multiple </v-icon> 
                    {{ project.people }}
                </v-card-text>
            </v-card-actions>
            <v-card-actions class="bar">
                <v-card-text class=" pr-0 pt-3">
                    <v-icon small dark>mdi-message-reply-text</v-icon>&nbsp;&nbsp;
                </v-card-text>
                <v-card-text class="pr-0 pt-3" id="colorHandle">
                    <v-icon small dark>mdi-eye</v-icon>&nbsp;&nbsp;{{project.viewCnt}}
                </v-card-text>
            </v-card-actions>
          </v-card>
        </v-col>
        </v-row>
        
        <v-row justify="center" style="margin-top:50px">
            <v-col  cols="7" md="3">
            <input type="text" class="search" v-model="keyword"/>
            </v-col>
            <v-col cols="2" md="1">
                <v-btn class="searchBtn" @click=goSearch color="red darken-3" dark small>
                    <v-icon>
                        mdi-magnify
                    </v-icon>
                </v-btn>
            </v-col>
        </v-row>
        </v-container>
</template>

<script>
import axios from 'axios'

export default {
    name:'ProjectList',
    props: {
         searchList : {
            type: Array,
            required: true
        }
    },
    data () {
        return {
            keyword:'',
        }
    },
    methods: {
        goSearch(){
                const {keyword} = this
                console.log(keyword)
                axios.post('http://localhost:7777/board/project/search', {keyword})
                .then((res) => {
                    console.log(res.data)
                    this.$router.push({name: 'ProjectSearchPage', params: { searchList: res.data }})
                })
                .catch (() => {
                    alert('문제 발생!')
                })
            },
    }
    } 
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');

.v-data-table {
    width:90%;
    font-family: 'Noto Sans KR', sans-serif;
}
.v-card {
    font-family: 'Noto Sans KR', sans-serif;
}
.headerTitle{ 
  font-size: 20pt;
}
.v-data-table::v-deep th {
  font-size: 14px !important;
}
.thum {
   margin-left:auto;
   margin-right: auto;
    width:280px;
    height:280px;
}
#colorHandle {
    color:white;
}
.search {
    position: relative;
    width:300px;
    height:30px;
    background-color: rgb(240, 238, 238);
    outline-color: rgb(211, 32, 32);
    padding-left:10px;
    font-family: 'Noto Sans KR', sans-serif;
    float:left;
}
.bar {
    background-color: rgb(0, 0, 0);
    height:35px;
}
.searchBtn {
    position: relative;
    float:left;
    margin-left:10%;
}
.pageBtn{
    font-family: 'Noto Sans KR', sans-serif;
}
</style>