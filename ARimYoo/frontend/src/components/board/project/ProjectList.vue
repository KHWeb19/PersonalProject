<template>
    <v-container>
        <v-row column wrap justify="center" v-if="keyword ==''">
            <v-col v-for="project in paginatedData" :key="project.projectNo" lg="3" sm="6">
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
                <v-card-text class=" pr-0 pt-3" id="colorHandle">
                    <v-icon small dark>mdi-message-reply-text</v-icon>&nbsp;&nbsp; {{project.commentCnt}}
                </v-card-text>
                <v-card-text class="pr-0 pt-3" id="colorHandle">
                    <v-icon small dark>mdi-eye</v-icon>&nbsp;&nbsp;{{project.viewCnt}}
                </v-card-text>
            </v-card-actions>
          </v-card>
        </v-col>
        </v-row>
        <v-row column wrap justify="center" v-else>
            <v-col v-for="project in mainProjectList" :key="project.projectNo" lg="3" sm="6">
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
                <v-card-text class=" pr-0 pt-3" id="colorHandle">
                    <v-icon small dark>mdi-message-reply-text</v-icon>&nbsp;&nbsp; {{project.commentCnt}}
                </v-card-text>
                <v-card-text class="pr-0 pt-3" id="colorHandle">
                    <v-icon small dark>mdi-eye</v-icon>&nbsp;&nbsp;{{project.viewCnt}}
                </v-card-text>
            </v-card-actions>
          </v-card>
        </v-col>
        </v-row>
        <v-row justify="end" style="margin-top:50px">
            <div class="pageBtn">
                <v-btn :disabled="pageNum === 0" small @click="prevPage" color="red darken-3" dark>
                    <v-icon>mdi-arrow-left-bold</v-icon>
                </v-btn>&nbsp;
                <span class="page-count">
                    {{ pageNum + 1 }} / {{ pageCount }}
                </span>&nbsp;
                <v-btn :disabled="pageNum >= pageCount - 1" @click="nextPage" small color="red darken-3">
                    <v-icon>mdi-arrow-right-bold</v-icon>
                </v-btn>
          </div>
        </v-row>
        <v-row justify="center" class="mt-15 mb-5">
            <v-col cols="12" >
                <search @search="doSearch" />
            </v-col>
        </v-row>
        </v-container>
</template>

<script>
import Search from '@/components/button/Search.vue';
import { mapActions, mapState } from 'vuex';

export default {
  components: { Search },
    name:'ProjectList',
    props: {
        projects: {
            type:Array
        }
        ,
        listArray: {
            type: Array,
            required: true,
        },
        pageSize: {
            type: Number,
            required: false,
            default: 16,
        }
    },
    data () {
        return {
            keyword:'',
            searchList: [],
            pageNum:0
        }
    },
    computed : {
         ...mapState(['mainProjectList']),
        pageCount() {
            let listLeng = this.listArray.length,
            listSize = this.pageSize,
            page = Math.floor(listLeng / listSize);

            if (listLeng % listSize > 0) page += 1;
            return page;
         },
        paginatedData() {
            const start = this.pageNum * this.pageSize,
            end = start + this.pageSize;
            return this.listArray.slice(start, end);
        },
    },
    methods: {
        ...mapActions(['fetchMainProjectList']),
        doSearch(keyword){
            this.keyword = keyword
            console.log(keyword)
            this.fetchMainProjectList(keyword)
            }
        },
                nextPage() {
      this.pageNum += 1;
    },
    prevPage() {
      this.pageNum -= 1;
    },
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