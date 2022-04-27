import {
    FETCH_CAKE_LISTS,
    FETCH_BOOKING_LISTS,
    FETCH_BOOKING_BOARD,
    FETCH_BOARD_COMMENTS,
    FETCH_REVIEWS,
    FETCH_MEMBER_INFO,
    BOOKING_ID_LISTS,
    FETCH_REVIEWS_LISTS,
    FETCH_MEMBER_LISTS,
    FETCH_BOOKING_LISTS_DATE
}from './mutation-types'

export default {
    [FETCH_CAKE_LISTS] (state, cakeLists) {
        state.cakeLists = cakeLists
    },
    [FETCH_BOOKING_LISTS] (state, bookingLists) {
        state.bookingLists = bookingLists
    },
    [FETCH_BOOKING_BOARD] (state, BookingBoard) {
        state.BookingBoard = BookingBoard
    },
    [FETCH_BOARD_COMMENTS] (state, boardComments) {
        state.boardComments = boardComments
    },
    [FETCH_REVIEWS] (state, reviews) {
        state.reviews = reviews
    },
    [FETCH_MEMBER_INFO] (state, memberInfo) {
        state.memberInfo = memberInfo
    },
    [FETCH_MEMBER_INFO] (state, memberInfo) {
        state.memberInfo = memberInfo
    },
    [BOOKING_ID_LISTS] (state, bookingIdLists) {
        state.bookingIdLists = bookingIdLists
    },
    [FETCH_REVIEWS_LISTS] (state, reviewsIdLists) {
        state.reviewsIdLists = reviewsIdLists
    },
    [FETCH_MEMBER_LISTS] (state, memberLists) {
        state.memberLists = memberLists
    },
    [FETCH_BOOKING_LISTS_DATE] (state, bookingListsDate) {
        state.bookingListsDate = bookingListsDate
    },
}