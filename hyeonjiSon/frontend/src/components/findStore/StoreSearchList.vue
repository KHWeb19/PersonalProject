<template>
    <v-container>
        <v-row justify="center" style="margin-top:50px">
            <v-spacer></v-spacer>
            <v-text-field
               class="search"
               v-model="keyWord"
               label="Search"
               placeholder="동을 입력해주세요."
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

   <br><br>

        <v-row column wrap justify="center">
            <v-data-table
                        :headers="headerTitle" 
                        :items="searchList"
                        :key="searchList.memberNo"
                        :items-per-page="10"
                        class="elevation-1" 
                        >
            </v-data-table>
        </v-row>
    </v-container>
</template>

<script>
import axios from 'axios';

export default {
    name: "StoreSearchList.vue",
    props: {
        searchList: {
            type:Array,
            required: true
        }
    },
    data () {
        return {
            headerTitle: [
                { text:'시', value: 'city', width:'150px'},
                { text:'동', value: 'dong', width:'150px'},
                { text: '주소', value: 'address', width: "350px" },
                { text: '상호명', value: 'storeName', width: "150px" },
            ],
            keyWord:'',

}
    },
    methods: {
        search(){
                const {keyWord} = this;
                console.log(keyWord)
                axios.post('http://localhost:7777/jpaMember/search', {keyWord})
                .then((res) => {
                    alert('검색완료')
                    console.log(res.data)
                    this.$router.push( this.$router.currentRoute, {params: { searchList: res.data }})
                })                                                          //keyWord: this.keyWord
                .catch (() => {
                    alert('문제 발생!')
                });
            }
    }
}
</script>

<style scoped>
.td {
  margin: 20px;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}
</style>