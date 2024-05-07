CREATE TABLE IF NOT EXISTS calender_event (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL
);

INSERT INTO calender_event (title, description, start_time, end_time) VALUES ('Meeting', 'Meeting with the team', '10:00', '11:00');