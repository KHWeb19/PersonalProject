<template>
    <v-container>
        <v-row justify="center" class="menu">
            <v-icon x-large color="black">
                mdi-circle
            </v-icon>
            <v-col cols="10">
                <img src="@/assets/title/communityTitle.png" class="menuTitle">
            </v-col>
        </v-row>
            <v-data-table 
                            :headers="headerTitle" 
                            :items="mainCommunityList"
                            :key="mainCommunityList.boardNo"
                            :items-per-page="5"
                            class="elevation-1 grey lighten-4" 
                            >
                    <template v-slot:[`item.title`]="{ item }">
                    <router-link :to="{ name: 'CommunityReadPage',
                                            params: { boardNo: item.boardNo.toString() } }"
                                            style="color:black; float:left">
                        {{ item.title }} &nbsp;&nbsp;&nbsp;&nbsp;
                    </router-link>
                    <div style="color:#D50000; float:left" >
                        [{{ item.commentCnt }}] &nbsp;
                    </div>
                    <div v-if="item.fileName">
                        <v-icon style="zoom:0.9">
                            mdi-image
                        </v-icon>
                    </div>
                    </template>
            </v-data-table>
        <v-row justify="center" class="menu">
            <v-icon x-large color="black">
                mdi-circle
            </v-icon>
            <v-col cols="10">
                <img src="@/assets/title/marketTitle.png" class="menuTitle2">
            </v-col>
        </v-row>
        <v-data-table 
                            :headers="headerTitle2" 
                            :items="mainMarketList"
                            :key="mainMarketList.boardNo"
                            :items-per-page="5"
                            class="elevation-1 grey lighten-4" 
                            >
                    <template v-slot:[`item.title`]="{ item }">
                    <router-link :to="{ name: 'MarketReadPage',
                                            params: { boardNo: item.boardNo.toString() } }"
                                            style="color:black; float:left">
                        {{ item.title }} &nbsp;&nbsp;&nbsp;&nbsp;
                    </router-link>
                    <div style="color:#D50000; float:left" >
                        [{{ item.commentCnt }}] &nbsp;
                    </div>
                    <div v-if="item.fileName">
                        <v-icon style="zoom:0.9">
                            mdi-image
                        </v-icon>
                    </div>
                    </template>
            </v-data-table>
            <v-row justify="center" class="menu">
            <v-icon x-large color="black">
                mdi-circle
            </v-icon>
            <v-col cols="10">
                <img src="@/assets/title/reviewTitle.png" class="menuTitle2">
            </v-col>
        </v-row>
        <v-data-table 
                            :headers="headerTitle3" 
                            :items="mainReviewList"
                            :key="mainReviewList.reviewNo"
                            :items-per-page="5"
                            class="elevation-1 grey lighten-4" 
                            >
                    <template v-slot:[`item.title`]="{ item }">
                    <router-link :to="{ name: 'ReviewReadPage',
                                            params: { reviewNo: item.reviewNo.toString() } }"
                                            style="color:black; float:left">
                        {{ item.title }} &nbsp;&nbsp;&nbsp;&nbsp;
                    </router-link>
                    <div style="color:#D50000; float:left" >
                        [{{ item.commentCnt }}] &nbsp;
                    </div>
                    <div v-if="item.fileName">
                        <v-icon style="zoom:0.9">
                            mdi-image
                        </v-icon>
                    </div>
                    </template>
            </v-data-table>
            <v-row justify="center" class="menu">
                
                    <v-icon x-large color="black">
                        mdi-circle
                    </v-icon>
                    <v-col cols="5">
                    <img src="@/assets/title/studyTitle.png" style="width:135px" class="mt-2">
                </v-col>
                
                <v-icon x-large color="black" class="ml-10">
                mdi-circle
            </v-icon>
            <v-col cols="2">
                <img src="@/assets/title/projectTitle.png" style="width:170px" class="mt-2">
            </v-col>
        </v-row>
        <v-row>
            <v-data-table 
                            :headers="headerTitle4" 
                            :items="mainStudyList"
                            :key="mainStudyList.studyNo"
                            :items-per-page="5"
                            class="elevation-1 grey lighten-4 ml-4 mb-5" 
                            style="width:550px"
                            >
                    <template v-slot:[`item.title`]="{ item }">
                    <router-link :to="{ name: 'StudyReadPage',
                                            params: { studyNo: item.studyNo.toString() } }"
                                            style="color:black; float:left">
                        {{ item.studyName }} &nbsp;&nbsp;&nbsp;&nbsp;
                    </router-link>
                    <div style="color:#D50000; float:left" >
                        [{{ item.commentCnt }}] &nbsp;
                    </div>
                    <div v-if="item.fileName">
                        <v-icon style="zoom:0.9">
                            mdi-image
                        </v-icon>
                    </div>
                    </template>
            </v-data-table>
            <v-data-table 
                            :headers="headerTitle5" 
                            :items="mainProjectList"
                            :key="mainProjectList.projectNo"
                            :items-per-page="5"
                            class="elevation-1 grey lighten-4 ml-14 mb-5" 
                            style="width:550px"
                           
                            >
                    <template v-slot:[`item.title`]="{ item }">
                    <router-link :to="{ name: 'ProjectReadPage',
                                            params: { projectNo: item.projectNo.toString() } }"
                                            style="color:black; float:left">
                        {{ item.projectName }} &nbsp;&nbsp;&nbsp;&nbsp;
                    </router-link>
                    <div style="color:#D50000; float:left" >
                        [{{ item.commentCnt }}] &nbsp;
                    </div>
                    <div v-if="item.fileName">
                        <v-icon style="zoom:0.9">
                            mdi-image
                        </v-icon>
                    </div>
                    </template>
            </v-data-table>
        </v-row>

    </v-container>
</template>

<script>
export default {
    name:'SearchResult',
    props: {
        mainCommunityList: {
            type:Array,
            required:true
        },
        mainMarketList: {
            type:Array,
            required:true
        },
        mainReviewList: {
            type:Array,
            required:true
        },
        mainStudyList: {
            type: Array,
            required:true
        },
        mainProjectList: {
            type: Array,
            required:true
        }
    },
    data () {
        return {
             headerTitle: [
                { text:'글 번호', value: 'boardNo', width:'70px'},
                { text:'말머리', value: 'brackets', width:'70px'},
                { text: '제목', value: 'title', width: "200px" },
                { text: '작성자', value: 'writer', width: "100px" },
                { text: '💛', value: 'likeCnt', width: "50px" },
                { text: '조회수', value: 'viewCnt', width: "70px" },
                { text: 'date. ', value: 'regDate', width: "100px" },
            ],
            headerTitle2: [
                { text:'글 번호', value: 'boardNo', width:'70px'},
                { text:'카테고리', value: 'category', width:'70px'},
                { text: '제목', value: 'title', width: "200px" },
                { text: '작성자', value: 'writer', width: "100px" },
                { text: '조회수', value: 'viewCnt', width: "70px" },
                { text: 'date. ', value: 'regDate', width: "100px" },
            ],
            headerTitle3: [
                { text:'글 번호', value: 'reviewNo', width:'70px'},
                { text:'말머리', value: 'brackets', width:'70px'},
                { text: '제목', value: 'title', width: "200px" },
                { text: '작성자', value: 'writer', width: "100px" },
                { text: '💛', value: 'likeCnt', width: "50px" },
                { text: '조회수', value: 'viewCnt', width: "70px" },
                { text: 'date. ', value: 'regDate', width: "100px" },
            ],
            headerTitle4: [
                { text:'글 번호', value: 'studyNo', width:'60px'},
                { text:'스터디장', value: 'writer', width:'70px'},
                { text: '스터디 이름', value: 'studyName', width: "150px" },
                { text: '정원', value: 'people', width: "70px" },
            ],
            headerTitle5: [
                { text:'글 번호', value: 'projectNo', width:'60px'},
                { text:'프로젝트장', value: 'writer', width:'70px'},
                { text: '프로젝트 이름', value: 'projectName', width: "150px" },
                { text: '정원', value: 'people', width: "70px" },
            ],
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');

.menu{
    margin-top:3%;
    margin-bottom:3%;
}
.menuTitle {
    width:200px;
}
.menuTitle2 {
    width:150px;
}
.v-data-table {
    font-family: 'Noto Sans KR', sans-serif;

}
</style>