<template>
    <v-container style="width:1000px">

        <template>
            <v-row justify="center" style="margin-top:0px">
                <v-col cols="2" md="1">
                    <v-btn id="registerBtn" @click="register" dark>
                    <v-icon id="icon">mdi-clipboard-edit-outline</v-icon>
                    &ensp;
                    <v-icon id="icon">ADD</v-icon>
                    </v-btn>
                </v-col>

                <v-spacer></v-spacer>
                <v-text-field
                class="search"
                v-model="keyWord"
                label="Search"
                placeholder="작성자를 검색해주세요."
                single-line
                hide-details
                ></v-text-field>
                <v-col cols="2" md="1">
                    <v-btn id="searchBtn" @click="search" dark small>
                        <v-icon>
                            mdi-magnify
                        </v-icon>
                    </v-btn>
                </v-col>
            </v-row>
        </template>
    <br>


    <template>
        <v-card class="pa-3" flat>
          <v-row>
            <v-col v-for="tipBoard in paginatedData" 
                     :key="tipBoard.boardNo"
                     cols="12" sm="6" md="4" lg="3">
               <v-hover v-slot="{hover}" close-delay="50">
                    <v-card
                            :elevation="hover ? 16:2" class="{ 'on-hover': hover }" 
                            @click="readTip(tipBoard.boardNo, tipBoard.id)"
                            style="margin: 10px; width: 320px; height: 300px;">              
                    <v-toolbar style="background-color: #193821; color: #d5e0d8" dark class="tipTitle">     
                                <v-toolbar-title>{{ tipBoard.title }}</v-toolbar-title>
                            <v-spacer></v-spacer>
                                <v-icon color="#ccbce3"> mdi-cards-heart </v-icon>
                                &ensp;
                                <span> {{ tipBoard.likeCnt }} </span>
                    </v-toolbar>

                        <v-card-text style="color: #6f7a72" 
                                     cols="12">
                                {{ tipBoard.content.substr(0,203) }} </v-card-text>

                        <v-card-text class="card-text-id caption" style="color: darkKhaki; font-weight: bold">
                            <v-divider style="margin-bottom:10px"></v-divider>
                            {{ tipBoard.writer.substr(0,6) }}
                        </v-card-text>
                        <v-card-text class="card-text-date caption">
                            {{new Date(tipBoard.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(0, 11)}}
                        </v-card-text>
                    </v-card>
               </v-hover>
            </v-col>
          </v-row>
        </v-card>

    </template>
    
    <template>
        <v-container justify="center" >
         <v-row>
            <v-col>
            <div class="btn-cover" align="center">
                <v-btn
                    :disabled="pageNum === 0"
                    @click="prevPage"
                    class="page-btn">
                이전
                </v-btn>
                <span class="page-count"
                >{{ pageNum + 1 }} / {{ pageCount }} 페이지</span
                >
                <v-btn
                    :disabled="pageNum >= pageCount - 1"
                    @click="nextPage"
                    class="page-btn"
                >
                다음
                </v-btn>
            </div>
            </v-col>
         </v-row>
        </v-container>
    </template>

    </v-container>
</template>

<script>
import axios from 'axios';

export default {
    name: 'TipBoardList',
    props: {
        tipBoards: {
            type: Array
        },
        listArray: {
            type: Array,
            required: true,
        },
        pageSize: {
            type: Number,
            required: false,
            default: 8,
        }
    },
    data() {
        return {
            pageNum: 0,
            keyWord: ''
        }
    },
    methods: {
        register() {
            this.$router.push({ name:'tipRegisterPage' })
        },
        readTip(boardNo, id) {
            this.$router.push({ name:'TipReadPage', params: {boardNo: boardNo, id: id} })
        },
        search() {
            const { keyWord } = this;
            axios.post("http://localhost:7777/tipboard/search", { keyWord })
                .then((res) => {
                console.log(res.data);
                alert("검색 완료");
                this.$router.push({ name: 'livingTipSearchList', params: { searchList: res.data, keyWord: this.keyWord },
                    })
                    .catch(() => {});
                })
                .catch(() => {
                alert("검색 실패");
            });
        },
        nextPage() {
            this.pageNum += 1;
        },
        prevPage() {
            this.pageNum -= 1;
        },
    },
    computed: {
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
}
</script>

<style scoped>

.v-text-field >>> .v-input__slot::before  { 
  border-color: #ccbce3 !important;
  }
.v-text-field >>> .v-input__slot::after {
    border-color: #ccbce3 !important;
    }
#searchBtn {
    background-color: darkkhaki;
    box-shadow: none;
}
#registerBtn {
    background-color: darkkhaki;
    box-shadow: none;
}
#icon{
    color: white;
}

.tipTitle {
      font-size: 12px;
}
.card-text-id {
  position: absolute;
  bottom: 0;
  text-align: left;
}
.card-text-date {
  position: absolute;
  bottom: 0;
  text-align: right;
}
#page-btn{
    background-color: darkkhaki;
    box-shadow: none;    
}
</style>