<template>
    <div>
        <v-container>
        <v-row justify="center" style="margin-top:50px">

            <v-btn @click="register">
               <v-icon>add</v-icon>
            </v-btn>

            <v-spacer></v-spacer>
            <v-text-field
               class="search"
               v-model="keyWord"
               label="Search"
               placeholder="검색어를 입력해주세요."
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

         <v-row>
            <v-col
            class="search_input"
            v-if="!searchList ||
                (Array.isArray(searchList) && searchList.length === 0)"
            >
                검색 결과가 없습니다.
            </v-col>

            <v-col v-for="tipBoard in searchList" 
                     :key="tipBoard.boardNo" lg="3" sm="6">
               <v-card @click="tipRead(tipBoard.boardNo)"
                     style="margin:10px; width: 250px; height: 300px;">              
               <v-toolbar dark>
                     <router-link :to="{ name: 'TipReadPage',
                                                params: { boardNo: tipBoard.boardNo.toString() } }">      
                  <v-toolbar-title>{{ tipBoard.title }}</v-toolbar-title>
                     </router-link>
               </v-toolbar>   

                     <v-card-text>{{ tipBoard.content }} </v-card-text>
                           <v-divider></v-divider>
               </v-card>
            </v-col>
         </v-row>
         

        </v-container>
    </div>
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

</style>