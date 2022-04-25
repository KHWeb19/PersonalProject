<template>
    <v-container>

        <template>
            <v-row justify="center" style="margin-top:50px">

                <v-btn @click="register">
                <v-icon>add</v-icon>
                </v-btn>

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
                    <v-btn class="searchBtn" @click="search" dark small>
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
            <v-col
            class="search_input"
            v-if="!searchList ||
                (Array.isArray(searchList) && searchList.length === 0)"
            >
                검색 결과가 없습니다.
            </v-col>

            <v-col v-for="tipBoard in searchList" 
                     :key="tipBoard.boardNo"
                     cols="12" sm="6" md="4" lg="3">
               <v-hover v-slot="{hover}" close-delay="50">
                    <v-card
                            :elevation="hover ? 16:2" class="{ 'on-hover': hover }" 
                            @click="readTip(tipBoard.boardNo, tipBoard.id)"
                            style="margin:10px; width: 320px; height: 300px;">              
                    <v-toolbar dark class="tipTitle">     
                                <v-toolbar-title>{{ tipBoard.title.substr(0,10) }}</v-toolbar-title>
                            <v-spacer></v-spacer>
                                <v-icon color="green"> mdi-cards-heart </v-icon>
                                &ensp;
                                <span> 15 </span>
                    </v-toolbar>

                        <v-card-text cols="12">{{ tipBoard.content.substr(0,203) }} </v-card-text>

                        <v-card-text class="card-text-id caption" style="color: green">
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

    </v-container>
</template>

<script>
import axios from 'axios'

export default {
    name: 'TipSearchList',
    props: {
        searchList: {
            type: Array
        }
    },
    data() {
        return {
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
        }
    }
}
</script>

<style scoped>
.tipTitle {
      font-size: 12px;
}
.card-text-id {
  position: absolute;
  bottom: 0;
}
.card-text-date {
  position: absolute;
  bottom: 0;
  text-align: right;
}
</style>