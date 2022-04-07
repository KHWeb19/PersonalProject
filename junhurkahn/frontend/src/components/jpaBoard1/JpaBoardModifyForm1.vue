<template>
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>계좌번호 수정하기</td>
                    <td>
                        <input type="text" :value="jpaBoard1.boardNo" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>은행이름</td>
                    <td>
                        <input type="text" v-model="title"/>
                    </td>
                </tr>
                <tr>
                    <td>계좌번호</td>
                    <td>
                        <input type="text" :value="jpaBoard1.writer"/>
                    </td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td>
                        <input type="text" :value="jpaBoard1.regDate" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>본문</td>
                    <td>
                        <textarea cols="50" rows="20" v-model="content">
                        </textarea>
                    </td>
                </tr>
            </table>

            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'JpaBoardReadPage1',
                                    params: { boardNo: jpaBoard1.boardNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: 'JpaBoardModifyForm1',
    props: {
        jpaBoard1: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
            writer:'',
            content: ''
        }
    },
    methods: {
        onSubmit () {
            const { title, content, writer } = this
            this.$emit('submit', { title, content, writer })
        }
    },
    created () {
        this.title = this.jpaBoard1.title
        this.content = this.jpaBoard1.content
        this.writer = this.jpaBoard1.writer
    }
}
</script>