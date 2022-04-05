<template>
     <div>
            <table>
                <tr>
                    <td>id </td>
                    <td>
                        <input type="text" :value="userInfo.birth" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>pw</td>
                    <td>
                        <input type="text" :value="userInfo.pw"/>
                    </td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td>
                        <input type="text"  disabled/>
                    </td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td>
                        <input type="text"  disabled/>
                    </td>
                </tr>
                <tr>
                    <td>본문</td>
                    <td>
                        <textarea cols="50" rows="20" >
                        </textarea>
                    </td>
                </tr>
            </table>
    </div>
</template>
<script>
export default {
    name: 'MemberInfo',
    props: {
        userInfo: {
            type: Object,
            required: true
        }
    }
}
</script>