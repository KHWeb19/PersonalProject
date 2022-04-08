<template>
    <div>
        <form @submit.prevent="onSubmit">
           <table border="1">
                <tr>
                    <td>사이트아이디 수정하기</td>
                    <td>
                        <input type="text" :value="jpaBoard4.boardNo" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>사이트아이디</td>
                    <td>
                        <input type="text" v-model="title"/>
                    </td>
                </tr>

              <tr>
                <td>사이트이름</td>
                <td>
                    <input type="text" v-model="writer1"/>
                </td>
            </tr>

                <tr>
                    <td>사이트주소</td>
                    <td>
                        <input type="text" :value="jpaBoard4.writer"/>
                    </td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td>
                        <input type="text" :value="jpaBoard4.regDate" disabled/>
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
                <router-link :to="{ name: 'JpaBoardReadPage4',
                                    params: { boardNo: jpaBoard4.boardNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: 'JpaBoardModifyForm4',
    props: {
        jpaBoard4: {
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
        this.title = this.jpaBoard4.title
        this.content = this.jpaBoard4.content
        this.writer = this.jpaBoard4.writer
    }
}
</script>