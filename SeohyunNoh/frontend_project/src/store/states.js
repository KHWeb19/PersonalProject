export default {
    //MEMBER
    isLogin: false,
    userInfo: [],
    session: [],

    idRules: [
        id => !!id || '아이디를 입력해주세요!',
        id => /^[a-zA-Z0-9]*$/.test(id) || '아이디는 영문 + 숫자만 입력 가능합니다.',
        id => !(id && id.length >= 15) || '아이디는 15자 이상 입력할 수 없습니다.'
    ],
    pwRules: [
        pw => !!pw || '비밀번호를 입력해주세요!',
    ],
    nameRules: [
        name => !!name || '이름을 입력해주세요!'
    ],
    birthRules: [
        birth => !!birth || '생일을 입력해주세요!'
    ],
    genderRules: [
        gender => !!gender || '성별을 입력해주세요!'
    ],
    addrRules: [
        address => !!address || '주소를 입력해주세요!'
    ],


    //NOTICE
    noticeBoards: [],
    noticeBoard: null, 

    //QNA
    qnaBoards: [],
    qnaBoard: null,
}