<template>
        <v-container>
                <div style="margin-left: 136px;">
                    <v-btn id=vb tile color="black white--text" :style="{marginTop:'24px',fontSize:'x-large'}" >                
                <v-icon>mdi-magnify</v-icon>  
            검색
            </v-btn>
                <v-col cols="1" md="3">
                <v-text-field v-model="search" dense outlined label="검색 키워드" :style="{marginTop:'10px'}" color="white" background-color="#3949AB"/>
                </v-col>
                </div> 
        <v-row column wrap justify="center">
            <v-data-table style="width: 75%" dark dense v-if="!complaintBoards || (Array.isArray(complaintBoards) && complaintBoards.length === 0)"
            :headers="headerTitle">
            </v-data-table>
            <v-data-table v-else
                        style="width: 75%" dark dense
                        :headers="headerTitle" 
                        :items="complaintBoards"
                        :key="complaintBoards.boardNo"
                        :items-per-page="10"
                        :search="search"
                        class="elevation-1">
                        <template v-slot:[`item.title`]="{ item }">
                            <router-link id=sj style=text-decoration:none; :to="{ name: 'ComplaintBoardReadPage',
                            params: { boardNo: item.boardNo.toString() } }">
                            {{ item.title }}
                            </router-link>
                            <div v-if="item.commentCnt" style="color:white; float:right" >
                            [{{ item.commentCnt }}]
                            </div>
                        </template>
            </v-data-table>
        </v-row>
        </v-container>
</template>

<script>

export default {
    name: 'ComplaintBoardList',
    props: {
      complaintBoards: {
            type: Array
        }
    },
    data () {
        return {
            search:'',
            headerTitle: [
                { text:'번호', value: 'boardNo', width:'50px', align:'center'},
                { text: '제목', value: 'title', width: "200px", align:'center'},
                { text: '작성자', value: 'writer', width: "100px", align:'center' },
                { text: '작성일 ', value: 'createdDate', width: "110px", align:'center'},
                { text: '조회', value: 'viewCnt', width: "50px", align:'center'},   
            ],
        }
    },
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Cute+Font&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Hubballi&display=swap');
#sj{
    color:white;
}
.v-data-table {
    width:90%;
    font-family: 'Noto Sans KR', sans-serif;
}
.headerTitle{ 
  font-size: 50px;
}
.v-data-table::v-deep th {
  font-size: 15px !important;
}
.v-data-table::v-deep td {
  font-size: 15px !important;
}
</style>