<template>
    <div>
        <form @submit.prevent="onSubmit">
            <table2>
                <tr>
                    <td>게시물 번호</td>
                    <td>
                        <input type="text" style="width:410px; color:white" :value="localBoard.boardNo" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td>
                        <input type="text" style="width:410px; color:white" v-model="title"/>
                    </td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td>
                        <input type="text" style="width:410px; color:white" :value="localBoard.writer" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td>
                        <input type="text" style="width:410px; color:white" :value="localBoard.createdDate" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>본문</td>
                    <td>
                        <textarea cols="50" rows="10" v-model="content" style="color:white">
                        </textarea>
                    </td>
                </tr>
            </table2>

            <div>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <v-btn v-if="this.$store.state.userInfo.nickname == localBoard.writer" type="submit" tile color="grey darken-2 white--text" width="100" :style="{fontSize:'medium'}"><v-icon>mdi-check</v-icon>
                수정 완료</v-btn>                
                <router-link style=text-decoration:none; :to="{ name: 'LocalBoardReadPage',
                                    params: { boardNo: localBoard.boardNo.toString() } }">
                <v-btn v-if="this.$store.state.userInfo.nickname == localBoard.writer" type="button" tile color="grey darken-4 white--text" width="100" :style="{fontSize:'medium'}"><v-icon> mdi-close-circle-outline</v-icon>
                취소</v-btn>
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>

export default {
    name: 'LocalBoardModifyForm',
    props: {
        localBoard: {
            type: Object,
            required: true
        },
    },
    data () {
        return {
            title: '',
            content: '',
        }
    },
    methods: {
        onSubmit () {
            const { title, content, viewCnt} = this
            this.$emit('submit', { title, content, viewCnt})
        },
    },
    created () {
        this.title = this.localBoard.title
        this.content = this.localBoard.content
        this.viewCnt = this.localBoard.viewCnt
    }
}
</script>