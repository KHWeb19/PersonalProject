<template>
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td class="guide">제목</td>
                </tr>
                <tr>
                    <td>
                        <textarea type="text" v-model="title"/>
                    </td>
                </tr>
                <tr>
                    <td class="guide">본문</td>
                </tr>               
                <tr>
                    <td>
                        <textarea cols="50" rows="20" v-model="content">
                        </textarea>
                    </td>
                </tr>
            </table>

            <div style="width: 500px; margin: 30px;">
                <v-row>
                <router-link :to="{ name: 'TipReadPage',
                                    params: { boardNo: tipBoard.boardNo.toString() } }">
                    <v-btn id="btn">돌아가기</v-btn>
                </router-link>
                <v-spacer></v-spacer>
                <v-btn id="btn" type="submit">수정 완료</v-btn>
                </v-row>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: 'TipModifyForm',
    props: {
        tipBoard: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
            content: ''
        }
    },
    methods: {
        onSubmit () {
            const { title, content } = this
            this.$emit('submit', { title, content })
        }
    },
    created () {
        this.title = this.tipBoard.title
        this.content = this.tipBoard.content
    }
}
</script>

<style scoped>
.guide{
    font-weight: bold;
    color: #907bb0;
}
able {
    border: collapse;
    border-radius: 10px;
    width: 500px;
}
tr {
    height: 30px;
}
textarea {
    width: 100%;
    margin: 0px;
    outline-color: #ccbce3;
    resize: none; /* 크기 조절 없앰 */
}
a {
    text-decoration: none;
    } 

#btn{
    color: white;
    background-color: darkkhaki;
    width: 100px;
    box-shadow: none;  
}
</style>