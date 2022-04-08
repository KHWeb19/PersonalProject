<template>
    <v-container>
        <v-row column wrap justify="center">
            <v-data-table 
                        :headers="headerTitle" 
                        :items="communityBoards"
                        :key="communityBoards.boardNo"
                        :items-per-page="10"
                        class="elevation-1 grey lighten-4" 
                        >
                <template v-slot:[`item.title`]="{ item }">
                   <router-link :to="{ name: 'CommunityReadPage',
                                        params: { boardNo: item.boardNo.toString() } }"
                                        style="color:black">
                    {{ item.title }}
                   </router-link>
                </template>
            </v-data-table>
        </v-row>
        
        </v-container>
</template>

<script>
export default {
    name:'CommunityBoardList',
    props: {
        communityBoards: {
            type:Array
        }
    },
    data () {
        return {
            headerTitle: [
                { text:'글 번호', value: 'boardNo', width:'70px'},
                { text:'말머리', value: 'brackets', width:'70px'},
                { text: '제목', value: 'title', width: "200px" },
                { text: '작성자', value: 'writer', width: "100px" },
                { text: '조회수', value: 'viewCnt', width: "70px" },
                { text: 'date. ', value: 'regDate', width: "100px" },
            ],
        }
    },
    methods: {
      
        }
    } 
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');

.v-data-table {
    width:90%;
    font-family: 'Noto Sans KR', sans-serif;
}
.headerTitle{ 
  font-size: 20pt;
}
.v-data-table::v-deep th {
  font-size: 14px !important;
}
</style>