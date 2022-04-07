<template>
    <v-container>
           <v-data-table v-if="!communityBoards || (Array.isArray(communityBoards) && communityBoards.length === 0)"
            :headers="headerTitle">
            </v-data-table>
            <v-data-table v-else
            :headers="headerTitle"
                        :items="communityBoards"
                        :items-per-page="10"
                        class="elevation-1">
            </v-data-table>
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
                { text: '제목', value: 'title', width: "200px" },
                { text: '작성자', value: 'writer', width: "100px" },
                { text: '조회수', value: 'viewCnt', width: "70px" },
                { text: 'date. ', value: 'date', width: "100px" },
            ],
        }
    },
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');

v-data-table {
    font-family: 'Noto Sans KR', sans-serif;
}
</style>