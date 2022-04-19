<template>
    <v-container>
        <v-card width="300" height="450" class="mx-auto">
            <router-link to="">
            <v-img :src="require('@/assets/profile.png')" class="thum"/>
            </router-link>
             <v-card-title> 하루 1시간 코드리뷰 </v-card-title>
             <v-card-actions>
              <v-card-text class="pb-0 pt-0">writer</v-card-text>
            </v-card-actions>
            <v-card-actions>
              <v-card-text class="pt-0"><v-icon small >mdi-eye</v-icon></v-card-text>
            </v-card-actions>
        </v-card>
        <v-row column wrap justify="center">
            <v-col v-for="study in paginatedData" :key="study.studyNo" lg="3" sm="6">
          <v-card width="280" height="370" class="mx-auto">
            <router-link to="">
              <v-img
                :src="require(`@/assets/back/study/${study.filename}`)"
                height="200px"
              ></v-img>
            </router-link>

            <v-card-title> {{ study.title }} </v-card-title>

            <v-card-subtitle> {{ study.des }} </v-card-subtitle>

            <v-card-actions>
              <v-card-text class="pb-0 pt-0">{{ study.writer }}</v-card-text>
            </v-card-actions>
            <v-card-actions>
              <v-card-text class="pt-0">조회 수</v-card-text>
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
    name:'StudyList',
    props: {
        studys: {
            type:Array
        }
    },
    data () {
        return {
            keyword:'',
            searchList: []
        }
    },
    methods: {
        goSearch(){
                const {keyword} = this
                console.log(keyword)
                axios.post('http://localhost:7777/board/review/search', {keyword})
                .then((res) => {
                    console.log(res.data)
                    this.$router.push({name: 'ReviewSearchPage', params: { searchList: res.data }})
                })
                .catch (() => {
                    alert('문제 발생!')
                })
            }
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
    width:300px;
    height:300px;
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
.searchBtn {
    position: relative;
    float:left;
    margin-left:10%;
}
</style>